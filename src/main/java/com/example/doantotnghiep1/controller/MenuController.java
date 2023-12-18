package com.example.doantotnghiep1.controller;

import com.example.doantotnghiep1.entity.Menu;
import com.example.doantotnghiep1.service.MenuService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/menu")
public class MenuController {
    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/add")
    public String add(Model model){
        Menu menu = new Menu();
        model.addAttribute("addMenu", menu);
        return "addFood";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("addMenu") Menu menu){
        menu
                .type(menu.getType())
                .name(menu.getName())
                .images("/image/" + menu.getImages())
                .price(menu.getPrice());
        menuService.add(menu);
                return "redirect:/menu/getAd";
    }

    @GetMapping("/update/{id}")
    public String updateMenu(@PathVariable String id, Model model){
        model.addAttribute("editMenu", menuService.getById(id));
        return "editFood";
    }

   @PostMapping("/edit/{id}")
   public String updateMenu(@PathVariable String id, @ModelAttribute("editMenu") Menu menu){
        menuService.update(id, menu);
        return "redirect:/menu/getAd";
   }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        menuService.deleteMenu(id);
        return "redirect:/menu/getAd";
    }

    @GetMapping("/getAd")
    public String getMenuAd(Model model){
        List<Menu> menuAD = menuService.getAll();
        model.addAttribute("menuAd", menuAD );
        return "MenuAdmin";
    }

    @GetMapping("/getAll")
    public String getMenu(Model model, String type){
        List<Menu> menu = menuService.getByType("drink");
        model.addAttribute("menu", menu );
        return "menu";
    }

    @GetMapping("/getFood")
    public String getMenuFood(Model model, String type){
        List<Menu> menu = menuService.getByType("food");
        model.addAttribute("menu", menu );
        return "menufood";
    }

    @GetMapping("/getOther")
    public String getMenuOther(Model model, String type){
        List<Menu> menu = menuService.getByType("other");
        model.addAttribute("menu", menu );
        return "menuother";
    }
}
