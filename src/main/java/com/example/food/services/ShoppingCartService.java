package com.example.food.services;

import com.example.food.dto.adminDto.ShoppingCartDto;

import java.util.List;

public interface ShoppingCartService {

    ShoppingCartDto createShoppingCart(ShoppingCartDto shoppingCartDto);

    List findAllShoppingCart(int page, int size) throws IllegalAccessException;

    List getByClientLogin(String login);

    void deleteShoppingCartDish(Long id);

}
