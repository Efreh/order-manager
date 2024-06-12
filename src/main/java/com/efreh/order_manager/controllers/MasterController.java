package com.efreh.order_manager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MasterController {
    @GetMapping("/master")
    public String masterPage(){
        return "/master";
    }
}
