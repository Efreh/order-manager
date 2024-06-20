package com.efreh.order_manager.entity.order;

import jakarta.persistence.*;

@Entity
@Table(name = "order_positions")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "positionId")
    private int positionId;

    @ManyToOne
    @JoinColumn(name = "orderIdInPos")
    private Order order;

    @Column(name = "orderNumber",length = 50)
    private String orderNumber;

    @Column(name = "orderPosition",length = 50,nullable = false)
    private String orderPosition;

    @Column(name = "amount")
    private int amount;

    @Column(name = "workOperation1",length = 50)
    private String workOperation1;
    @Column(name = "workOperation2",length = 50)
    private String workOperation2;
    @Column(name = "workOperation3",length = 50)
    private String workOperation3;
    @Column(name = "workOperation4",length = 50)
    private String workOperation4;

    public Position() {
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderPosition() {
        return orderPosition;
    }

    public void setOrderPosition(String orderPosition) {
        this.orderPosition = orderPosition;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getWorkOperation1() {
        return workOperation1;
    }

    public void setWorkOperation1(String workOperation1) {
        this.workOperation1 = workOperation1;
    }

    public String getWorkOperation2() {
        return workOperation2;
    }

    public void setWorkOperation2(String workOperation2) {
        this.workOperation2 = workOperation2;
    }

    public String getWorkOperation3() {
        return workOperation3;
    }

    public void setWorkOperation3(String workOperation3) {
        this.workOperation3 = workOperation3;
    }

    public String getWorkOperation4() {
        return workOperation4;
    }

    public void setWorkOperation4(String workOperation4) {
        this.workOperation4 = workOperation4;
    }
}
