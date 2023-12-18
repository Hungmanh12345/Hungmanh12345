package com.example.doantotnghiep1.service;

import com.example.doantotnghiep1.entity.Menu;
import com.example.doantotnghiep1.repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService{
    private final MenuRepository menuRepository;

    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public Menu add(Menu menu){
        return menuRepository.save(menu);
    }

    @Override
    public Menu update(String id, Menu menu){
        Menu existMenu = menuRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Không tìm thấy")
        );
        existMenu
                .type(menu.getType())
                .images(menu.getImages())
                .description(menu.getDescription())
                .price(menu.getPrice())
                .name(menu.getName());
        return existMenu;
    }
    @Override
    public String deleteMenu(String id){
        Menu menu = menuRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Không tìm thấy")
        );
        menuRepository.save(delete(menu));
        return "đã xóa: " + id;
    }

    public Menu delete(Menu menu) {
        menu.setIsDeleted(1L);
        return menu;
    }
    @Override
    public List<Menu> getAll(){
        return menuRepository.findAll();
    }

    @Override
    public List<Menu> getByType(String type){
        return menuRepository.findByType(type);
    }

    @Override
    public Menu getById(String id){
        return menuRepository.findById(id).get();
    }
}
