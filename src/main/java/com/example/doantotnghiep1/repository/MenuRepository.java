package com.example.doantotnghiep1.repository;

import com.example.doantotnghiep1.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, String> {
    List<Menu> findByType(String type);

    List<Menu> findByName(String name);
}
