package com.example.food.services.impl;

import com.example.food.dto.adminDto.ClientsDishesDto;
import com.example.food.repositories.ClientsDishesRepository;
import com.example.food.services.ClientsDishesService;
import com.example.food.services.ModelMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientsDishesServiceImpl implements ClientsDishesService, ModelMapperService {
    @Autowired
    private ClientsDishesRepository clientsDishesRepository;

    @Override
    public List<ClientsDishesDto> getAllClientsDishes() {
        List<ClientsDishesDto> clientsDishesDtoList = new ArrayList<>();
        map(clientsDishesRepository.findAll(), clientsDishesDtoList);
        return clientsDishesDtoList;
    }
}
