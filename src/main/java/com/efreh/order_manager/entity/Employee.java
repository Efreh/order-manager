package com.efreh.order_manager.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
public class Employee {
    private static final String NOT_NULL_MESSAGE = "Поле не должно быть пустым";
    private static final String RU_PATTERN = "^[а-яА-Я]+$";
    private static final String MAX_LENGTH_20_MESSAGE = "Максимальная длина поля - 20 символов";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeId")
    private Long employeeId;

    @Column(name = "login_phone", unique = true, nullable = false, length = 10)
    @NotBlank(message = NOT_NULL_MESSAGE)
    @Size(min = 10, max = 10, message = "Длинна номера должна быть 10 символов")
    @Pattern(regexp = "^\\d+$", message = "Поле должно содержать только цифры.")
    private String login_phone;

    @Column(name = "name", nullable = false, length = 20)
    @NotBlank(message = NOT_NULL_MESSAGE)
    @Size(max = 20, message = MAX_LENGTH_20_MESSAGE)
    @Pattern(regexp = RU_PATTERN)
    private String name;

    @Column(name = "otchestvo", length = 20)
    @Size(max = 20, message = MAX_LENGTH_20_MESSAGE)
    @Pattern(regexp = RU_PATTERN)
    private String otchestvo;

    @Column(name = "surname", nullable = false, length = 20)
    @NotBlank(message = NOT_NULL_MESSAGE)
    @Size(max = 20, message = MAX_LENGTH_20_MESSAGE)
    @Pattern(regexp = RU_PATTERN)
    private String surname;

    @Column(name = "department", nullable = false, length = 20)
    @NotBlank(message = NOT_NULL_MESSAGE)
    @Size(max = 20, message = MAX_LENGTH_20_MESSAGE)
    private String department;

    @Column(name = "sector", nullable = false, length = 10)
    @NotBlank(message = NOT_NULL_MESSAGE)
    @Size(max = 10, message = "Максимальная длинна поля - 10 символов")
    private String sector;

    @Column(name = "work_center", length = 20)
    @Size(max = 20, message = MAX_LENGTH_20_MESSAGE)
    private String work_center;

    @Column(name = "job_title", length = 20)
    @Size(max = 20, message = MAX_LENGTH_20_MESSAGE)
    private String job_title;
}
