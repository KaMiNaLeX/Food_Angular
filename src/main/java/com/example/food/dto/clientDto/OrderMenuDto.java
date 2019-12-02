package com.example.food.dto.clientDto;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

public class OrderMenuDto {
    private BigInteger id;
    private BigInteger sum;
    private Timestamp timeOrder;
    private String imgSource;
    private List<OrderDishDto> orderDishDtoList;

    public String getImgSource() {
        return imgSource;
    }

    public void setImgSource(String imgSource) {
        this.imgSource = imgSource;
    }

    public List<OrderDishDto> getOrderDishDtoList() {
        return orderDishDtoList;
    }

    public void setOrderDishDtoList(List<OrderDishDto> orderDishDtoList) {
        this.orderDishDtoList = orderDishDtoList;
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


    public BigInteger getSum() {
        return sum;
    }

    public void setSum(BigInteger sum) {
        this.sum = sum;
    }
}
