package com.efreh.order_manager.dao;

import com.efreh.order_manager.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findBySurnameAndName(String surname, String name);
}
