package com.example.food.controllers;

import com.example.food.dto.adminDto.ClientsDishesDto;
import com.example.food.services.ClientsDishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("clients/dishes")
public class ClientsDishesController {
    @Autowired
    private ClientsDishesService clientsDishesService;

    @GetMapping("/")
    public List<ClientsDishesDto> getAllClientsDishes() {
        return clientsDishesService.getAllClientsDishes();
    }
}
