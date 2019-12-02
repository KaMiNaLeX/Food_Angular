package com.example.food.dto.adminDto;

import java.io.Serializable;
import java.math.BigInteger;

public class ShoppingCartDto implements Serializable {
    private BigInteger id;
    private BigInteger dishId;
    private BigInteger clientId;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getDishId() {
        return dishId;
    }

    public void setDishId(BigInteger dishId) {
        this.dishId = dishId;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

}
