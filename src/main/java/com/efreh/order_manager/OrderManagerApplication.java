package com.efreh.order_manager;

import com.efreh.order_manager.dao.EmployeeRepository;
import com.efreh.order_manager.entity.Employee;
import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrderManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderManagerApplication.class, args);

//        ApplicationContext context = SpringApplication.run(OrderManagerApplication.class,args);
//        EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
//
//        Employee employee = new Employee("8651259648"
//                , "Alex"
//                , "Mihaylivich"
//                , "Ludov"
//                , "110"
//                , "112"
//                , "KDX"
//                , "Operator");
//        employeeRepository.save(employee);
    }

}
