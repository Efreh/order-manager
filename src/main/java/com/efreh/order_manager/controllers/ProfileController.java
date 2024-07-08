package com.efreh.order_manager.controllers;

import com.efreh.order_manager.entity.authN.User;
import com.efreh.order_manager.service.UserService;
import jakarta.validation.Valid;
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
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUser(@ModelAttribute("user") @Valid User user, BindingResult result) {
        if (!user.getPasswordTransient().equals(user.getPasswordConfirmTransient())) {
            result.rejectValue("passwordConfirmTransient", "error.user", "Пароли не совпадают");
        }
        if (!userService.uniqueUser(user)){
            result.rejectValue("username","error.user","Номер уже зарегестрирован");
        }

        if (result.hasErrors()) {
            return "registration";
        } else {
            userService.saveUser(user);
            return "redirect:/index";
        }
    }

    @GetMapping("/employee/profileEditor")
    public String editProfile(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        return "profileEditor";
    }

    @PostMapping("/employee/profileEditor")
    public String saveEditProfile(@ModelAttribute("user")  User user,
                                  BindingResult result,
                                  Model model) {
        if (!userService.mergeUser(user) || result.hasErrors()) {
            return "profileEditor";
        } else {
            return "redirect:/employee";
        }
    }
}
