package com.efreh.order_manager;

import com.efreh.order_manager.dao.EmployeeRepository;
import com.efreh.order_manager.dao.UserRepository;
import com.efreh.order_manager.entity.Employee;
import com.efreh.order_manager.entity.authN.User;
import com.efreh.order_manager.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.userdetails.UserDetailsService;

@SpringBootApplication
public class OrderManagerApplication {

    public static void main(String[] args) {
//        SpringApplication.run(OrderManagerApplication.class, args);

        ApplicationContext context = SpringApplication.run(OrderManagerApplication.class, args);

        UserService userService = context.getBean("userService", UserService.class);
        EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);

        User user = new User();
        user.setUsername("test");
        user.setPassword("test");
        user.setPasswordConfirm("test");

        Employee employee = new Employee("8651259648"
                , "Alex"
                , "Mihaylivich"
                , "Ludov"
                , "110"
                , "112"
                , "KDX"
                , "Operator");
        employeeRepository.save(employee);

        user.setEmployee(employee);
        userService.saveUser(user);

        employee.setUser(user);
        employeeRepository.save(employee);

    }

}
