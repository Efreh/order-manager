package com.efreh.order_manager.service;

import com.efreh.order_manager.dao.EmployeeRepository;
import com.efreh.order_manager.entity.Employee;
import com.efreh.order_manager.entity.authN.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee getEmpFromDB (User user){
        return employeeRepository.findById(user.getEmployee().getId()).orElse(null);
    }
}
