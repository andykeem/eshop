package com.example.eshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"", "/"})
    public String home(Model model) {
        String title = "Madison Island";
        model.addAttribute("title", title);
        return "home/index";
    }
}
