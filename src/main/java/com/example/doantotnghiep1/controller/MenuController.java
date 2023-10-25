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

    @PostMapping("/add")
    public ResponseEntity<Menu> add(@RequestBody Menu menu){
        Menu result = menuService.add(menu);
        return ResponseEntity.ok().body(result);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Menu> update(@RequestBody Menu menu , @PathVariable String id){
        Menu result = menuService.update(id, menu);
        return ResponseEntity.ok().body(result);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id){
        String result = menuService.deleteMenu(id);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/getByName/{type}")
    public ResponseEntity<List<Menu>> getByType(@PathVariable String type){
        List<Menu> result = menuService.getByType(type);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/getAll")
    public String getMenu(Model model){
        List<Menu> menu = menuService.getAll();
        Set<String> distinctTypes = menu.stream()
                .map(Menu::getType)
                .collect(Collectors.toSet());

        model.addAttribute("distinctTypes", distinctTypes);
        model.addAttribute("menu", menu );
        return "menu";
    }
}
