package com.efreh.order_manager.entity.order;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_positions")
@Data
@NoArgsConstructor
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "positionId")
    private int positionId;

    @ManyToOne
    private Order order;

    @Column(name = "orderNumber",nullable = false, length = 20)
    @NotBlank(message = "Поле не должно быть пустым")
    @Size(max = 20, message = "Длинна должна быть не более 20 символов")
    private String orderNumber;

    @Column(name = "orderPosition",nullable = false, length = 20)
    @NotBlank(message = "Поле не должно быть пустым")
    @Size(max = 20, message = "Длинна должна быть не более 20 символов")
    private String orderPosition;

    @Column(name = "amount", length = 10)
//    @NotNull(message = "Поле не должно быть пустым")
//    @Size(max = 10, message = "Длинна должна быть не более 10 символов")
    private int amount;

    @Column(name = "workOperation1", length = 50)
    @Size(max = 50, message = "Длинна должна быть не более 50 символов")
    private String workOperation1;

    @Column(name = "workOperation2", length = 50)
    @Size(max = 50, message = "Длинна должна быть не более 50 символов")
    private String workOperation2;

    @Column(name = "workOperation3", length = 50)
    @Size(max = 50, message = "Длинна должна быть не более 50 символов")
    private String workOperation3;

    @Column(name = "workOperation4", length = 50)
    @Size(max = 50, message = "Длинна должна быть не более 50 символов")
    private String workOperation4;
}
