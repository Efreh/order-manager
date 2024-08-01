package com.efreh.order_manager.controllers;

import com.efreh.order_manager.dto.UserDTO;
import com.efreh.order_manager.entity.Employee;
import com.efreh.order_manager.entity.authN.User;
import com.efreh.order_manager.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfileController {
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String showRegistrationPage(Model model) {
        model.addAttribute("user", new UserDTO());
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUser(@ModelAttribute("user") @Valid UserDTO userDTO, BindingResult result) {
        if (!userDTO.getPassword().equals(userDTO.getPasswordConfirm())) {
            result.rejectValue("passwordConfirmTransient", "error.user", "Пароли не совпадают");
        }
        if (!userService.uniqueUser(userDTO)){
            result.rejectValue("username","error.user","Номер уже зарегестрирован");
        }

        if (result.hasErrors()) {
            return "registration";
        } else {
            userService.saveUser(userDTO);
            return "redirect:/index";
        }
    }

    @GetMapping("/employee/profileEditor")
    public String editProfile(@AuthenticationPrincipal User user, Model model) {
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user.getEmployee(),userDTO);
        model.addAttribute("user", userDTO);
        return "profileEditor";
    }

    @PostMapping("/employee/profileEditor")
    public String saveEditProfile(@ModelAttribute("user")  UserDTO userDTO,
                                  @AuthenticationPrincipal User user,
                                  BindingResult result,
                                  Model model) {
        userDTO.setPassword(userDTO.getPasswordConfirm());
        if (!userService.mergeUser(userDTO) || result.hasErrors()) {
            return "profileEditor";
        } else {
            model.addAttribute("employee", user.getEmployee());
            return "employee";
        }
    }
}
