package com.efreh.order_manager.controllers;

import com.efreh.order_manager.dao.EmployeeRepository;
import com.efreh.order_manager.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String index(@AuthenticationPrincipal UserDetails userDetails, Model model){
        Employee employee = employeeRepository.findById(1).orElse(null);
        model.addAttribute("name",employee.getName());
        model.addAttribute("otchestvo",employee.getOtchestvo());
        model.addAttribute("surname",employee.getSurname());
        model.addAttribute("department",employee.getDepartment());
        model.addAttribute("sector",employee.getSector());
        model.addAttribute("work_center",employee.getWork_center());
        model.addAttribute("job_title",employee.getJob_title());
        return "index";
    }
}
