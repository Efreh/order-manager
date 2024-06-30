package com.efreh.order_manager.controllers;

import com.efreh.order_manager.entity.authN.User;
import com.efreh.order_manager.entity.order.Order;
import com.efreh.order_manager.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class OrderViewController {
    @Autowired
    OrderService orderService;

    @GetMapping("/order/{id}")
    public String orderView (@PathVariable("id") Long orderId,
                             @AuthenticationPrincipal User user,
                             Model model){
        Order order = orderService.findOrderById(orderId);
        model.addAttribute("order",order);
        model.addAttribute("role",user.getRole());

        return "orderView";
    }

    @GetMapping("order/confirm/{id}")
    public String orderMasterConfirm (@PathVariable("id") Long orderId,
                             @AuthenticationPrincipal User user,
                             Model model){
        Order order = orderService.findOrderById(orderId);
        order.setMasterCheck(true);
        orderService.saveOrder(order);
        model.addAttribute("order",order);
        model.addAttribute("role",user.getRole());

        return "redirect:/master";
    }
}
