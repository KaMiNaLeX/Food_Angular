package com.example.food.services;

import com.example.food.dto.adminDto.OrdersDto;

import java.util.List;

public interface OrdersService {
    List getAllOrders(int page, int size) throws IllegalAccessException;

    OrdersDto createOrders(OrdersDto ordersDto);

    OrdersDto getOrderById(Long id);

    List getAllOrdersParam(String login);

    List getDishesByLogin(String login);

    List getDishesByOrderId(Long orderId);

}
