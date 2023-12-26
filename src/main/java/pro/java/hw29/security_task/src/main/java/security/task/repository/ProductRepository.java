package security.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import security.task.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}