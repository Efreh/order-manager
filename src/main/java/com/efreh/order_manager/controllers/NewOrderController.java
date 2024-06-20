package com.efreh.order_manager.controllers;

import com.efreh.order_manager.entity.order.Order;
import com.efreh.order_manager.entity.order.Position;
import com.efreh.order_manager.service.OrderService;
import com.efreh.order_manager.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NewOrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private PositionService positionService;

    @GetMapping("/newOrder")
    public String newOrder(Model model){
        model.addAttribute("order", new Order());
        return "/newOrder";
    }

    @PostMapping("/newOrder")
    public String createOrder(@ModelAttribute Order order, Model model){
        orderService.saveOrder(order);
        model.addAttribute("order",order);
        model.addAttribute("position", new Position());
        return "redirect:/employee";
    }

    @PostMapping("/newOrder/addPosition")
    public String addPosition(@ModelAttribute Position position, Model model){
        positionService.savePosition(position);
        Order order = position.getOrder();
        model.addAttribute("order", order);
        model.addAttribute("position", new Position());
        return "/newOrder";
    }
}
