package com.example.doantotnghiep1.controller;

import com.example.doantotnghiep1.entity.User;
import com.example.doantotnghiep1.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/update/{id}")
    public String update( @PathVariable String id, Model model){
        model.addAttribute("updateUser", userService.getUserById(id));
        return "editUser";
    }
    @PostMapping("/update/{id}")
    public String update(@PathVariable String id, @ModelAttribute("updateUser") User user){
            userService.updateUser(user, id);
            return "redirect:/user/users";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        userService.deleteUser(id);
        return "redirect:/user/users";
    }

    @GetMapping("/users")
    public String user(Model model){
        model.addAttribute("user", userService.getAll());
        return "user";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("user") User user){
        userService.add(user);
        return "redirect:/user/users";
    }

    @GetMapping("/addUser")
    public String addUser(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "addUser";
    }
}
