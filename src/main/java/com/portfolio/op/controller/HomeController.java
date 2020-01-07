package com.portfolio.op.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String hoem(Model model){
        model.addAttribute("test", "test");
        return "home";
    }
}
