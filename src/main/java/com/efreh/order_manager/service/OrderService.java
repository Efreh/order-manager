package com.efreh.order_manager.service;

import com.efreh.order_manager.dao.OrderRepository;
import com.efreh.order_manager.entity.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public boolean saveOrder(Order order) {
        orderRepository.save(order);
        return true;
    }

    public boolean deleteOrder(Long orderId) {
        if (orderRepository.findById(orderId).isPresent()) {
            orderRepository.deleteById(orderId);
            return true;
        } else
            return false;
    }

    public List<Order> lastFiveOrder(Long empId) {
        return orderRepository.findTop5ByEmployeeIdOrderByDateDesc(empId);
    }

    public Order findOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

}
