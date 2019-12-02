package com.example.food.services;

import com.example.food.dto.ClientsDto;
import com.example.food.models.Clients;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientsService {
    List getAllClients(int page, int size) throws IllegalAccessException;

    ClientsDto createClients(ClientsDto clientsDto);

    ClientsDto getClientsById(Long id);

    List getClientByLogin(String login);

    ClientsDto getByLogin(String login);

    ClientsDto getIdByLogin(String login);
}
