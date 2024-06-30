package com.efreh.order_manager.controllers;

import com.efreh.order_manager.entity.Employee;
import com.efreh.order_manager.entity.authN.User;
import com.efreh.order_manager.entity.order.Order;
import com.efreh.order_manager.service.EmployeeService;
import com.efreh.order_manager.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    OrderService orderService;

    @GetMapping("/employee")
    public String employeePage(@AuthenticationPrincipal User user, Model model) {
        Employee employee = employeeService.getEmpFromDB(user);
        model.addAttribute("employee", employee);

        List<Order> orders = orderService.lastFiveOrder(employee.getId());
        model.addAttribute("orders",orders);

        return "employee";
    }

    @GetMapping("/master")
    public String masterPage(@AuthenticationPrincipal User user, Model model) {
        Employee master = employeeService.getEmpFromDB(user);
        model.addAttribute("master", master);

        List<Order> orders = orderService.orderMasterForCheck(master.getSector());
        model.addAttribute("orders",orders);
        return "master";
    }
}
