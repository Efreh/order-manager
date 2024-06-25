package com.efreh.order_manager.controllers;

import com.efreh.order_manager.entity.authN.User;
import com.efreh.order_manager.entity.order.Order;
import com.efreh.order_manager.entity.order.Position;
import com.efreh.order_manager.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.time.LocalDate;
import java.util.Date;

@Controller
@SessionAttributes("order")
public class NewOrderController {
    @ModelAttribute("order")
    public Order createOrder() {
        return new Order();
    }

    @Autowired
    private OrderService orderService;

    @GetMapping("/newOrder")
    public String newOrder(@ModelAttribute("order") Order order, Model model) {
        model.addAttribute("order", order);
        model.addAttribute("position", new Position());
        return "/newOrder";
    }
    @PostMapping("/newOrder")
    public String createOrder(@ModelAttribute("order") Order order, @AuthenticationPrincipal User user, SessionStatus sessionStatus){
        order.setEmployee(user.getEmployee());
        orderService.saveOrder(order);
        sessionStatus.setComplete();
        return "redirect:/employee";
    }

    @PostMapping("/newOrder/addPosition")
    public String addPosition(@ModelAttribute("order") Order order,@ModelAttribute Position position, Model model){
        position.setOrder(order);
        order.getPositionList().add(position);
        model.addAttribute("order",order);
        model.addAttribute("position", new Position());

        return "newOrder";
    }
}
