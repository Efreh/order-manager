package com.efreh.order_manager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private static final String NOT_NULL_MESSAGE = "Поле не должно быть пустым";
    private static final String MAX_LENGTH_20_MESSAGE = "Максимальная длина поля - 20 символов";
    private static final String PASS_PATTERN_MESSAGE = "Поле должно содержать минимум 1 цифру, без пробелов";

    private static final String RU_PATTERN = "^[а-яА-Я]+$";
    private static final String PASS_PATTERN = "^(?=.*\\d)[a-zA-Z0-9\\p{L}\\p{M}&&[^ ]]+$";
    private static final String NUMBER_PATTERN = "^\\d+$";

    @NotBlank(message = NOT_NULL_MESSAGE)
    @Size(min = 10, max = 10, message = "Длинна номера должна быть 10 символов")
    @Pattern(regexp = NUMBER_PATTERN, message = "Поле должно содержать только цифры.")
    private String phoneNumber;

    @NotBlank(message = NOT_NULL_MESSAGE)
    @Size(min = 8, message = "Минимальная длинна пароля: 8 символов")
    @Pattern(regexp = PASS_PATTERN, message = PASS_PATTERN_MESSAGE)
    private String password;

    @NotBlank(message = NOT_NULL_MESSAGE)
    @Size(min = 8, message = "Минимальная длинна пароля: 8 символов")
    @Pattern(regexp = PASS_PATTERN, message = PASS_PATTERN_MESSAGE)
    private String passwordConfirm;

    @NotBlank(message = NOT_NULL_MESSAGE)
    @Size(max = 20, message = MAX_LENGTH_20_MESSAGE)
    @Pattern(regexp = RU_PATTERN, message = "Поле должно содержать только кирилические символы")
    private String name;

    @Size(max = 20, message = MAX_LENGTH_20_MESSAGE)
    @Pattern(regexp = RU_PATTERN, message = "Поле должно содержать только кирилические символы")
    private String otchestvo;

    @NotBlank(message = NOT_NULL_MESSAGE)
    @Size(max = 20, message = MAX_LENGTH_20_MESSAGE)
    @Pattern(regexp = RU_PATTERN, message = "Поле должно содержать только кирилические символы")
    private String surname;

    @NotBlank(message = NOT_NULL_MESSAGE)
    @Size(max = 20, message = MAX_LENGTH_20_MESSAGE)
    private String department;

    @NotBlank(message = NOT_NULL_MESSAGE)
    @Size(max = 10, message = "Максимальная длинна поля - 10 символов")
    private String sector;

    @Size(max = 20, message = MAX_LENGTH_20_MESSAGE)
    private String workCenter;

    @Size(max = 20, message = MAX_LENGTH_20_MESSAGE)
    private String jobTitle;
}
