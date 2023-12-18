package com.example.doantotnghiep1.repository;

import com.example.doantotnghiep1.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, String> {
}
