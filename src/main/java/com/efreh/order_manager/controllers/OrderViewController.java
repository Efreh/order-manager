package com.efreh.order_manager.controllers;

import com.efreh.order_manager.entity.order.Order;
import com.efreh.order_manager.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class OrderViewController {
    @Autowired
    OrderService orderService;

    @GetMapping("/order/{id}")
    public String orderView (@PathVariable("id") Long orderId, Model model){
        Order order = orderService.findOrderById(orderId);
        model.addAttribute("order",order);
        return "orderView";
    }
}
