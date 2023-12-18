package com.example.doantotnghiep1.service;

import com.example.doantotnghiep1.entity.Food;
import com.example.doantotnghiep1.repository.FoodRepository;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl implements FoodService{
    private final FoodRepository foodRepository;

    public FoodServiceImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public Food add(Food food){
        return foodRepository.save(food);
    }


}
