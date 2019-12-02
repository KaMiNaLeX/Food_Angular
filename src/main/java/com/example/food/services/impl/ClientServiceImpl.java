package com.example.food.services.impl;

import com.example.food.dto.ClientsDto;
import com.example.food.models.Clients;
import com.example.food.repositories.ClientRepository;
import com.example.food.services.ClientsService;
import com.example.food.services.ModelMapperService;
import com.example.food.services.security.UserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ModelMapperService, ClientsService {
    private final Logger LOGGER = LoggerFactory.getLogger(ClientServiceImpl.class);
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List getAllClients(int page, int size) throws IllegalAccessException {
        Pageable pageable = PageRequest.of(page, size);
        Page<Map<String, Object>> pageClients = clientRepository.findAllClients(pageable);
        List<Map<String, Object>> list = pageClients.getContent();
        List<ClientsDto> resultList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map = list.get(i);
            ClientsDto clientsDto = new ClientsDto();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                Field field = null;
                try {
                    field = ClientsDto.class.getDeclaredField(entry.getKey());
                } catch (NoSuchFieldException e) {
                    LOGGER.warn("getAllClients:NoSuchFieldException");
                    continue;
                }
                field.setAccessible(true);
                field.set(clientsDto, entry.getValue());
            }
            resultList.add(clientsDto);

        }
        return resultList;

    }

    @Override
    public ClientsDto createClients(ClientsDto clientsDto) {
        clientsDto.setUserRole(UserRole.SIMPLE_USER_ROLE);
        clientsDto.setPassword(passwordEncoder.encode(clientsDto.getPassword()));
        Clients clients = new Clients();
        map(clientsDto, clients);
        map(clientRepository.save(clients), clientsDto);
        LOGGER.info("Client create");
        return clientsDto;
    }

    @Override
    public ClientsDto getClientsById(Long id) {
        Optional<Clients> optionalClients = clientRepository.findById(id);
        if (optionalClients.isPresent()) {
            ClientsDto clientsDto = new ClientsDto();
            map(optionalClients.get(), clientsDto);
            return clientsDto;
        }
        return null;
    }

    @Override
    public List getClientByLogin(String login) {
        List<ClientsDto> clientsDtoList = new ArrayList<>();
        map(clientRepository.getByLogin(login), clientsDtoList);
        return clientsDtoList;
    }

    @Override
    public ClientsDto getByLogin(String login) {
        ClientsDto clientsDto = new ClientsDto();
        map(clientRepository.findByLogin(login), clientsDto);
        return clientsDto;
    }

    @Override
    public ClientsDto getIdByLogin(String login) {
        ClientsDto clientsDto = new ClientsDto();
        map(clientRepository.getIdByLogin(login), clientsDto);
        return clientsDto;
    }

}
