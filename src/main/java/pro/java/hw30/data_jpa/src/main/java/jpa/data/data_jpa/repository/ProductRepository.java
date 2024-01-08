package jpa.data.data_jpa.repository;

import jpa.data.data_jpa.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Long> {
}
