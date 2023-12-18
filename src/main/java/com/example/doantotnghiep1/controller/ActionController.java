package com.example.doantotnghiep1.controller;

import com.example.doantotnghiep1.entity.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ActionController {
    private final Authentication authentication;

    public ActionController(Authentication authentication) {
        this.authentication = authentication;
    }

    @RequestMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/checklogin")
    public String login(@RequestParam("userName") String userName, @RequestParam("password") String password, Model model) {

        if (authentication.getUserName().equals(userName) && authentication.getPassword().equals(password)) {
            return "redirect:/admin";
        } else {
            model.addAttribute("error", "Đăng nhập thất bại");
            return "forward:/login";
        }
    }

    @GetMapping("/logout")
    public String logout() {
        return "login";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/menu")
    public String menu() {
        return "menu";
    }

    @GetMapping("/menuAd")
    public String menuAd() {
        return "MenuAdmin";
    }


    @GetMapping("/RevenueStatistics")
    public String revenue(){
        return "RevenueStatistics";
    }

    @GetMapping("/table")
    public String table() {
        return "table";
    }

}
