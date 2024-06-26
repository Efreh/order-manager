package com.efreh.order_manager.dao;

import com.efreh.order_manager.entity.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findTop5ByEmployeeIdOrderByDateDesc(Long employeeId);
}
