package com.example.food.controllers;

import com.example.food.dto.adminDto.MenuDto;
import com.example.food.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("/")
    public List getAllMenu(@RequestParam("page") int page, @RequestParam("size") int size)
            throws IllegalAccessException {
        return menuService.getAllMenu(page, size);
    }

    @PostMapping("/create")
    public MenuDto createMenu(@RequestBody MenuDto menuDto) {
        return menuService.createMenu(menuDto);
    }

}
