package jpa.data.data_jpa.service;

import jpa.data.data_jpa.model.Products;
import jpa.data.data_jpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Products addProduct(Products product) {
        return productRepository.save(product);
    }

    public Products getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
