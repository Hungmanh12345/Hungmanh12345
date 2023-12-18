package com.example.doantotnghiep1.service;

import com.example.doantotnghiep1.entity.Menu;

import java.util.List;

public interface MenuService {
    Menu add(Menu menu);

    Menu update(String id, Menu menu);

    String deleteMenu(String id);

    List<Menu> getAll();

    List<Menu> getByType(String type);


    Menu getById(String id);
}
