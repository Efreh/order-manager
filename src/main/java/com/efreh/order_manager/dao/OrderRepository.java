package com.efreh.order_manager.dao;

import com.efreh.order_manager.entity.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findTop5ByEmployeeIdOrderByDateDesc(Long employeeId);

    List<Order> findByDateAndWorkShift(LocalDate date, int workShift);

    @Query("SELECT o FROM Order o JOIN o.employee e WHERE e.sector = :sector AND o.masterCheck = false")
    List<Order> findOrdersBySectorAndMasterCheckFalse(@Param("sector") String sector);

    @Query("SELECT o FROM Order o JOIN o.employee e WHERE e.sector = :sector AND o.otkControllerCheck = false")
    List<Order> findOrdersBySectorAndOtkControllerCheckFalse(@Param("sector") String sector);
}
