package com.efreh.order_manager.controllers;

import com.efreh.order_manager.entity.Employee;
import com.efreh.order_manager.entity.authN.User;
import com.efreh.order_manager.entity.order.Order;
import com.efreh.order_manager.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    OrderService orderService;

    @GetMapping("/employee")
    public String employeePage(@AuthenticationPrincipal User user, Model model) {
        Employee employee = user.getEmployee();
        model.addAttribute("employee", employee);

        List<Order> orders = orderService.lastFiveOrder(employee.getId());
        model.addAttribute("orders", orders);

        return "employee";
    }

    @GetMapping("/master")
    public String masterPage(@AuthenticationPrincipal User user, Model model) {
        Employee master = user.getEmployee();
        model.addAttribute("master", master);

        List<Order> orders = orderService.orderMasterForCheck(master.getSector());
        model.addAttribute("orders", orders);
        return "master";
    }

    @GetMapping("/otkController")
    public String otkControllerPage(@AuthenticationPrincipal User user, Model model) {
        Employee otkController = user.getEmployee();
        model.addAttribute("otkController", otkController);

        List<Order> orders = orderService.orderOtkControllerForCheck(otkController.getSector());
        model.addAttribute("orders", orders);
        return "otkController";
    }

    @GetMapping("/employee/findOrder")
    public String findOrderOnEmployeePage(@AuthenticationPrincipal User user,
                               @RequestParam("date") LocalDate date,
                               @RequestParam("shift") int workShift,
                               Model model) {
        Employee employee = user.getEmployee();
        model.addAttribute("employee", employee);

        List<Order> orders = orderService.lastFiveOrder(employee.getId());
        model.addAttribute("orders", orders);

        List<Order> findOrders = orderService.findOrderByDateAndWorkShiftAndEmployee(date,workShift,employee);
        model.addAttribute("findOrders",findOrders);

        return "employee";
    }

    @GetMapping("/employee/findOrderMaster")
    public String findOrderOnMasterPage(@AuthenticationPrincipal User user,
                                          @RequestParam("date") LocalDate date,
                                          @RequestParam("shift") int workShift,
                                          @RequestParam("surname") String surname,
                                          @RequestParam("name") String name,
                                          Model model) {
        Employee master = user.getEmployee();
        model.addAttribute("master", master);

        List<Order> orders = orderService.orderMasterForCheck(master.getSector());
        model.addAttribute("orders", orders);

        List<Order> findOrders = orderService.findOrderByDateAndWorkShiftAndEmployee(date,workShift,surname,name);
        model.addAttribute("findOrders",findOrders);

        return "master";
    }

    @GetMapping("/employee/findOrderOTKController")
    public String findOrderOtkControllerPage(@AuthenticationPrincipal User user,
                                           @RequestParam("date") LocalDate date,
                                           @RequestParam("shift") int workShift,
                                           @RequestParam("surname") String surname,
                                           @RequestParam("name") String name,
                                           Model model) {
        Employee otkController = user.getEmployee();
        model.addAttribute("otkController", otkController);

        List<Order> orders = orderService.orderMasterForCheck(otkController.getSector());
        model.addAttribute("orders", orders);

        List<Order> findOrders = orderService.findOrderByDateAndWorkShiftAndEmployee(date,workShift,surname,name);
        model.addAttribute("findOrders",findOrders);

        return "otkController";
    }
}
