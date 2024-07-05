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
        return "profileRedactor";
    }

    @PostMapping("/registration")
    public String registerUser(@ModelAttribute("user")  User user, BindingResult result) {
        if (!user.getPassword().equals(user.getPasswordConfirm()) || result.hasErrors()) {
            return "profileRedactor";
        } else {

            userService.saveUser(user);

            return "redirect:/index";
        }
    }

    @GetMapping("/employee/editProfile")
    public String editProfile(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        return "profileRedactor";
    }

    @PostMapping("/employee/saveEditProfile")
    public String saveEditProfile(@ModelAttribute("user")  User user,
                                  BindingResult result,
                                  Model model) {
        if (!userService.mergeUser(user) || result.hasErrors()) {
            return "profileRedactor";
        } else {
            return "redirect:/employee";
        }
    }
}
