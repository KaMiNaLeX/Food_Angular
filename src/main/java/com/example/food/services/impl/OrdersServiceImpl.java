package com.example.food.services.impl;

import com.example.food.dto.adminDto.DishesDto;
import com.example.food.dto.adminDto.OrdersDto;
import com.example.food.dto.clientDto.OrderMenuDto;
import com.example.food.models.ClientsDishes;
import com.example.food.models.Orders;
import com.example.food.repositories.ClientsDishesRepository;
import com.example.food.repositories.OrderRepository;
import com.example.food.services.ModelMapperService;
import com.example.food.services.OrdersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class OrdersServiceImpl implements OrdersService, ModelMapperService {
    private final Logger LOGGER = LoggerFactory.getLogger(OrdersServiceImpl.class);
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ClientsDishesRepository clientsDishesRepository;

    @Override
    public List getAllOrders(int page, int size) throws IllegalAccessException {
        Pageable pageable = PageRequest.of(page, size);
        Page<Map<String, Object>> pageOrders = orderRepository.findAllOrders(pageable);
        List<Map<String, Object>> list = pageOrders.getContent();
        List<OrdersDto> resultList = new ArrayList<>();
        try {
            mapListMapToDto(list, resultList, OrdersDto.class);
        } catch (NoSuchMethodException e) {
            LOGGER.error("getAllOrders:NoSuchMethodException");
        } catch (InvocationTargetException e) {
            LOGGER.error("getAllOrders:InvocationTargetException");
        } catch (InstantiationException e) {
            LOGGER.error("getAllOrders:InstantiationException");
        }
        return resultList;
    }

    @Override
    public OrdersDto createOrders(OrdersDto ordersDto) {
        Orders orders = new Orders();
        map(ordersDto, orders);
        orders = orderRepository.save(orders);
        List<DishesDto> dishesDtoList = ordersDto.getDishesDtoList();
        for (int i = 0; i < dishesDtoList.size(); i++) {
            ClientsDishes clientsDishes = new ClientsDishes();
            //map(dishesDtoList.get(i), clientsDishes);
            clientsDishes.setClientId(ordersDto.getClientId().longValue());
            clientsDishes.setOrderId(orders.getId());
            clientsDishes.setDishId(dishesDtoList.get(i).getId().longValue());
            clientsDishesRepository.save(clientsDishes);
        }
        map(orders, ordersDto);
        LOGGER.info("Order create");
        return ordersDto;
    }

    @Override
    public OrdersDto getOrderById(Long id) {
        Optional<Orders> optionalOrders = orderRepository.findById(id);
        if (optionalOrders.isPresent()) {
            OrdersDto ordersDto = new OrdersDto();
            map(optionalOrders.get(), ordersDto);
            return ordersDto;
        }
        return null;
    }

    @Override
    public List getAllOrdersParam(String login) {
        List<OrderMenuDto> orderMenuDtoList = new ArrayList<>();
        map(orderRepository.getByLogin(login), orderMenuDtoList);
        return orderMenuDtoList;
    }

    @Override
    public List getDishesByLogin(String login) {
        List<OrderMenuDto> orderMenuDtoList = new ArrayList<>();
        map(orderRepository.getDishesByLogin(login), orderMenuDtoList);
        return orderMenuDtoList;
    }

    @Override
    public List getDishesByOrderId(Long orderId) {
        List<OrdersDto> ordersDtoList = new ArrayList<>();
        map(orderRepository.getDishesByOrderId(orderId), ordersDtoList);
        return ordersDtoList;
    }

    @Override
    @Transactional
    public void delete(Long orderId) {
        List<ClientsDishes> clientsDishesList = clientsDishesRepository.getByOrderId(orderId);
        for (int i = 0; i < clientsDishesList.size(); i++) {
            clientsDishesRepository.delete(clientsDishesList.get(i));
        }

        Orders orders = orderRepository.getById(orderId);
        orderRepository.delete(orders);

    }

    @Override
    @Transactional
    public void deleteAll(Long clientId) {
        List<ClientsDishes> clientsDishesList = clientsDishesRepository.findByClientId(clientId);
        for (int i = 0; i < clientsDishesList.size(); i++) {
            clientsDishesRepository.delete(clientsDishesList.get(i));
        }

        List<Orders> ordersList = orderRepository.findAllByClientId(clientId);
        for (int i = 0; i < ordersList.size(); i++) {
            orderRepository.delete(ordersList.get(i));
        }
    }

}
