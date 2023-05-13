package com.shawnkoong.orderservice.repository;

import com.shawnkoong.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
