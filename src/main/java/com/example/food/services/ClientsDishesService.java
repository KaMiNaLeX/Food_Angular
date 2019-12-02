package com.example.food.services;

import com.example.food.dto.adminDto.ClientsDishesDto;

import java.util.List;

public interface ClientsDishesService {
    List<ClientsDishesDto> getAllClientsDishes();
}
