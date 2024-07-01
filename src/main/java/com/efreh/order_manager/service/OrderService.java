package com.efreh.order_manager.service;

import com.efreh.order_manager.dao.OrderRepository;
import com.efreh.order_manager.entity.authN.User;
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

    public boolean deleteOrder(Long orderId, String role) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order == null) {
            return false;
        }

        boolean isMaster = role.equals("ROLE_MASTER");
        boolean isEligibleEmployee = role.equals("ROLE_EMPLOYEE") && !order.isMasterCheck() && !order.isOtkControllerCheck();

        if (isMaster || isEligibleEmployee) {
            orderRepository.deleteById(orderId);
            return true;
        }

        return false;
    }

    public void confirmOrder(Long orderId, User user) {
        Order order = orderRepository.findById(orderId).orElse(null);
        String role = user.getRole();
        if (order != null) {
            if (role.equals("ROLE_MASTER")) {
                order.setMasterCheck(true);
            } else if (role.equals("ROLE_CONTROLLER")) {
                order.setOtkControllerCheck(true);
            }
            saveOrder(order);
        }
    }

    public List<Order> lastFiveOrder(Long empId) {
        return orderRepository.findTop5ByEmployeeIdOrderByDateDesc(empId);
    }

    public List<Order> orderMasterForCheck(String sector) {
        return orderRepository.findOrdersBySectorAndMasterCheckFalse(sector);
    }

    public List<Order> orderOtkControllerForCheck(String sector) {
        return orderRepository.findOrdersBySectorAndOtkControllerCheckFalse(sector);
    }

    public Order findOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

}
