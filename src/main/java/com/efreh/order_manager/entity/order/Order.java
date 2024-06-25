package com.efreh.order_manager.entity.order;

import com.efreh.order_manager.entity.Employee;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId")
    private int orderId;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "workShift", nullable = false, length = 1)
    private int workShift;

    @ManyToOne
    private Employee employee;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Position> positionList = new ArrayList<>();

    @Column(name = "masterCheck", columnDefinition = "boolean default false")
    private boolean masterCheck;

    @Column(name = "otkControllerCheck", columnDefinition = "boolean default false")
    private boolean otkControllerCheck;

    public Order() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getWorkShift() {
        return workShift;
    }

    public void setWorkShift(int workShift) {
        this.workShift = workShift;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Position> getPositionList() {
        return positionList;
    }

    public void setPositionList(List<Position> positionList) {
        this.positionList = positionList;
    }

    public boolean isMasterCheck() {
        return masterCheck;
    }

    public void setMasterCheck(boolean masterCheck) {
        this.masterCheck = masterCheck;
    }

    public boolean isOtkControllerCheck() {
        return otkControllerCheck;
    }

    public void setOtkControllerCheck(boolean otkControllerCheck) {
        this.otkControllerCheck = otkControllerCheck;
    }
}
