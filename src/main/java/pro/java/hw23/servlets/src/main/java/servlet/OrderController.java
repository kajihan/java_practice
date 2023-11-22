package servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.ProductDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Order;
import model.Product;
import service.OrderRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@WebServlet("/order")
public class OrderController extends HttpServlet {
    private final OrderRepository orderRepository = new OrderRepository();
    private final ProductDAO productDAO = new ProductDAO();
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String orderIdParam = request.getParameter("id");

        if (orderIdParam != null) {
            int orderId = Integer.parseInt(orderIdParam);
            Order order = orderRepository.getOrderById(orderId);

            if (order != null) {
                sendJsonResponse(response, gson.toJson(order));
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        } else {
            List<Order> orders = orderRepository.getAllOrders();
            sendJsonResponse(response, gson.toJson(orders));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            String requestBody = "";
            try (BufferedReader reader = request.getReader()) {
                requestBody = reader.lines().collect(Collectors.joining(System.lineSeparator()));
            }
            Order newOrder = gson.fromJson(requestBody, Order.class);
            List<Product> products = newOrder.getOrderedProductIDs().stream()
                    .map(productDAO::getProductById)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());

            newOrder.setProducts(products);
            orderRepository.addOrder(newOrder);

            String jsonResponse = gson.toJson(newOrder);
            sendJsonResponse(response, jsonResponse);
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            System.out.println(e.getMessage());
        }
    }

    private void sendJsonResponse(HttpServletResponse response, String json)
            throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
    }
}
