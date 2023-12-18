package com.example.doantotnghiep1.controller;

import com.example.doantotnghiep1.entity.Food;
import com.example.doantotnghiep1.service.FoodService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/food")
public class FoodController {
    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/add")
    public String oderFood(Model model){
        Food food = new Food();
        model.addAttribute("oder", food);
        return "oderFood";
    }

    @PostMapping("/add")
    public String oderFood(@ModelAttribute("oder") Food food){
        food
                .name(food.getName())
                .phone(food.getPhone())
                .address(food.getAddress())
                .in4(food.getIn4())
                .nameFood(food.getNameFood());
        foodService.add(food);
        return "redirect:/menu/getAll";
    }
}
