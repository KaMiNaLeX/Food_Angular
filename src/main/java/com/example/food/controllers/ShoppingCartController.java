package com.example.food.controllers;

import com.example.food.dto.adminDto.ShoppingCartDto;
import com.example.food.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("shoppingCart")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;

    @PostMapping("/create")
    public ShoppingCartDto createShoppingCart(@RequestBody ShoppingCartDto shoppingCartDto) {
        return shoppingCartService.createShoppingCart(shoppingCartDto);
    }

    @GetMapping("/")
    public List getAllShoppingCartDishes(@RequestParam("page") int page, @RequestParam("size") int size)
            throws IllegalAccessException {
        return shoppingCartService.findAllShoppingCart(page, size);
    }

    @GetMapping("/{login}")
    public List getByClientLogin(@PathVariable("login") String login, Principal principal) {
        if (!principal.getName().equals(login)) {
            return new ArrayList();

        }
        return shoppingCartService.getByClientLogin(login);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
         shoppingCartService.deleteShoppingCartDish(id);
    }
}
