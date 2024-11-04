package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String loginPage() {
        return "login";  // Esto debe corresponder al nombre de tu archivo HTML de login
    }
}