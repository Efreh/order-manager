package com.efreh.order_manager.dao;

import com.efreh.order_manager.entity.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {

}
