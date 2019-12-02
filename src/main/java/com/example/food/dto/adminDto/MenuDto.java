package com.example.food.dto.adminDto;

import java.io.Serializable;
import java.math.BigInteger;

public class MenuDto implements Serializable {
    private BigInteger id;
    private String category;
    private BigInteger cost;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigInteger getCost() {
        return cost;
    }

    public void setCost(BigInteger cost) {
        this.cost = cost;
    }

}
