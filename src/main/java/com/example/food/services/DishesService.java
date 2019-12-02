package com.example.food.services;

import com.example.food.dto.adminDto.DishesDto;
import com.example.food.dto.clientDto.DishMenuDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DishesService {
    List getAllDishes(int page, int size) throws IllegalAccessException;

    List findAllDishesMenu(int page, int size) throws IllegalAccessException;

    List getAllDishesByCategory(String category);

    DishesDto createDish(DishesDto dishesDto);

    DishesDto getDishById(Long id);

    DishMenuDto ById(Long id);

}
