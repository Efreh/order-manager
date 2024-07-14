package com.efreh.order_manager.entity.order;

import com.efreh.order_manager.entity.Employee;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId")
    private int orderId;

    @Column(name = "date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd") //Важно для автовыставления даты на странице, если данные о наряде есть
    @NotNull(message = "Укажите дату")
    private LocalDate date;

    @Column(name = "workShift")
    private int workShift;

    @ManyToOne
    private Employee employee;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @NotEmpty(message = "Добавьте хотя бы 1 позицию")
    private List<Position> positionList = new ArrayList<>();

    @Column(name = "masterCheck", columnDefinition = "boolean default false")
    private boolean masterCheck;

    @Column(name = "otkControllerCheck", columnDefinition = "boolean default false")
    private boolean otkControllerCheck;
}
