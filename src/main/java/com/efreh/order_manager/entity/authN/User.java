package com.efreh.order_manager.entity.authN;

import com.efreh.order_manager.entity.Employee;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,length = 10)
    @NotBlank(message = "Поле не должно быть пустым")
    @Size(min = 10, max = 10, message = "Длинна номера должна быть 10 символов")
    @Pattern(regexp = "^\\d+$", message = "Поле должно содержать только цифры.")
    private String username;

    @Column
//    @Size(max = 30, message = "Минимальная длинна пароля: 8 символов")
//    @Pattern(regexp = "^(?=.*\\d)[a-zA-Z0-9\\p{L}\\p{M}&&[^ ]]+$", message = "Поле должно содержать минимум 1 цифру, без пробелов")
    private String password;

    @Transient
//    @Size(max = 30, message = "Минимальная длинна пароля: 8 символов")
//    @Pattern(regexp = "^(?=.*\\d)[a-zA-Z0-9\\p{L}\\p{M}&&[^ ]]+$", message = "Поле должно содержать минимум 1 цифру, без пробелов")
    private String passwordConfirm;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", referencedColumnName = "employeeId")
    private Employee employee;

    @Column(length = 20)
    private String role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.stream(getRole().split(", "))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }
}
