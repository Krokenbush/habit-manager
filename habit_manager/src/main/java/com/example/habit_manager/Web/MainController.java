package com.example.habit_manager.Web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String home() {
        return "home";
    }
    @GetMapping("/mainPage")
    public String mainPage() {
        return "mainPage";
    }
}
