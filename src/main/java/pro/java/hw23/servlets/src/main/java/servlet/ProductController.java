package servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.ProductDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;
import service.OrderRepository;
import service.ProductRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/products/*")
public class ProductController extends HttpServlet {
    private final ProductRepository productRepository = new ProductRepository();
    private final ProductDAO productDAO = new ProductDAO();
    private final OrderRepository orderRepository = new OrderRepository();
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String productIdParam = request.getParameter("id");

        if (productIdParam != null) {
            int productId = Integer.parseInt(productIdParam);
            Product product = productDAO.getProductById(productId);
            if (product != null) {
                sendJsonResponse(response, gson.toJson(product));
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        } else {
            List<Product> allProducts = productDAO.getAllProducts();
            sendJsonResponse(response, gson.toJson(allProducts));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            String requestBody = readRequestBody(request);
            Product newProduct = deserializeRequestBody(requestBody);
            addProductToRepository(newProduct);
            String jsonResponse = serializeResponse(newProduct);
            sendJsonResponse(response, jsonResponse);
        } catch (Exception e) {
            handleException(response, e);
        }
    }

    private String readRequestBody(HttpServletRequest request) throws IOException {
        BufferedReader reader = request.getReader();
        StringBuilder requestBody = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            requestBody.append(line);
        }
        return requestBody.toString();
    }

    private Product deserializeRequestBody(String requestBody) {
        return gson.fromJson(requestBody, Product.class);
    }

    private void addProductToRepository(Product newProduct) {
        productRepository.addProduct(newProduct);
    }

    private String serializeResponse(Product product) {
        return gson.toJson(product);
    }

    private void handleException(HttpServletResponse response, Exception e) {
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        System.out.println(e.getMessage());
    }

    private void sendJsonResponse(HttpServletResponse response, String json) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
    }
}
