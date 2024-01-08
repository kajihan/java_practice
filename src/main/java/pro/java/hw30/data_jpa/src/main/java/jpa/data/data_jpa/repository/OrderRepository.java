package jpa.data.data_jpa.repository;

import jpa.data.data_jpa.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
