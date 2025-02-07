package com.cibertec.hoteltulipan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String showHomePage() {
        // Redirigir a la URL de login
        return "home";
    }
}
