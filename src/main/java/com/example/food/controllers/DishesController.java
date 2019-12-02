package com.example.food.controllers;

import com.example.food.dto.adminDto.DishesDto;
import com.example.food.dto.clientDto.DishMenuDto;
import com.example.food.services.DishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("dishes")
public class DishesController {

    @Autowired
    private DishesService dishesService;

    @GetMapping("/")
    public List getAllDishes(@RequestParam("page") int page, @RequestParam("size") int size)
            throws IllegalAccessException {
        return dishesService.getAllDishes(page, size);
    }

    @GetMapping("/menu/")
    public List findAllDishesMenu(@RequestParam("page") int page, @RequestParam("size") int size)
            throws IllegalAccessException {
        return dishesService.findAllDishesMenu(page, size);
    }

    @PostMapping("/create")
    public DishesDto createDish(@RequestBody DishesDto dishesDto) {
        return dishesService.createDish(dishesDto);
    }

    @GetMapping("/{id}")
    public DishesDto getDishesById(@PathVariable("id") Long id) {
        return dishesService.getDishById(id);
    }

    @GetMapping("/category/{category}")
    public List getAllDishesByCategory(@PathVariable("category") String category) {
        return dishesService.getAllDishesByCategory(category);
    }

    @GetMapping("/id/{id}")
    public DishMenuDto getById(@PathVariable("id") Long id) {
        return dishesService.ById(id);
    }

}