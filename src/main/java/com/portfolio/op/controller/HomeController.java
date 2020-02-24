package com.portfolio.op.controller;

import com.portfolio.op.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    UserService userService;

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/")
    public String home(Model model){
        log.debug("dndndndnd");
        log.debug(userService.idCheck("gs951221"));
        model.addAttribute("test", "test");
        return "home";
    }
}
