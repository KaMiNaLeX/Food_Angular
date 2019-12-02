package com.example.food.services;

import com.example.food.dto.adminDto.MenuDto;

import java.util.List;

public interface MenuService {

    MenuDto createMenu(MenuDto menuDto);

    List getAllMenu(int page, int size) throws IllegalAccessException;

}
