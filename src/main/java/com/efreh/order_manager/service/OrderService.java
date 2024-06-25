package com.efreh.order_manager.service;

import com.efreh.order_manager.dao.OrderRepository;
import com.efreh.order_manager.entity.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public boolean saveOrder(Order order){
        orderRepository.save(order);
        return true;
    }

    public boolean deleteOrder(Long orderId){
        if (orderRepository.findById(orderId).isPresent()){
            orderRepository.deleteById(orderId);
            return true;
        }
        return false;
    }

}
