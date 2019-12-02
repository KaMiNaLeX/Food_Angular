package com.example.food.dto.adminDto;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

public class OrdersDto implements Serializable {
    private BigInteger id;
    private BigInteger clientId;
    private BigInteger sum;
    private Timestamp timeOrder;
    private List<DishesDto> dishesDtoList;

    public List<DishesDto> getDishesDtoList() {
        return dishesDtoList;
    }

    public void setDishesDtoList(List<DishesDto> dishesDtoList) {
        this.dishesDtoList = dishesDtoList;
    }

    public Timestamp getTimeOrder() {
        return timeOrder;
    }

    public void setTimeOrder(Timestamp timeOrder) {
        this.timeOrder = timeOrder;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    public BigInteger getSum() {
        return sum;
    }

    public void setSum(BigInteger sum) {
        this.sum = sum;
    }

}
