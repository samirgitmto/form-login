package com.fl.formlogin.controller.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/login")
    public String login() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated() && !auth.getName().equals("anonymousUser")) {
            System.out.println("Authenticated user trying to access login page, redirecting to home");
            return "redirect:/home";
        }
        System.out.println("Login page requested");
        return "login";
    }

    @GetMapping("/home")
    public String home() {
        System.out.println("Home page requested");
        return "home";
    }
} 