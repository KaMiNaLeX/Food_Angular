package com.example.food.dto.adminDto;

import com.example.food.dto.ClientsDto;

import java.io.Serializable;
import java.util.List;

public class ClientsDishesDto implements Serializable {
    private List<DishesDto> dishId;
    private List<ClientsDto> clientId;
    private List<OrdersDto> orderId;

    public List<DishesDto> getDishId() {
        return dishId;
    }

    public void setDishId(List<DishesDto> dishId) {
        this.dishId = dishId;
    }

    public List<ClientsDto> getClientId() {
        return clientId;
    }

    public void setClientId(List<ClientsDto> clientId) {
        this.clientId = clientId;
    }

    public List<OrdersDto> getOrderId() {
        return orderId;
    }

    public void setOrderId(List<OrdersDto> orderId) {
        this.orderId = orderId;
    }
}
