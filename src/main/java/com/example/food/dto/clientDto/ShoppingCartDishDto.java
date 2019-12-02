package com.example.food.dto.clientDto;

import java.io.Serializable;
import java.math.BigInteger;

public class ShoppingCartDishDto implements Serializable {
    private BigInteger id;
    private String description;
    private BigInteger mass;
    private String name;
    private String imgSource;
    private String category;
    private BigInteger cost;
    private BigInteger menuId;
    private BigInteger dishId;

    public BigInteger getDishId() {
        return dishId;
    }

    public void setDishId(BigInteger dishId) {
        this.dishId = dishId;
    }

    public BigInteger getMenuId() {
        return menuId;
    }

    public void setMenuId(BigInteger menuId) {
        this.menuId = menuId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getMass() {
        return mass;
    }

    public void setMass(BigInteger mass) {
        this.mass = mass;
    }

    public String getImgSource() {
        return imgSource;
    }

    public void setImgSource(String imgSource) {
        this.imgSource = imgSource;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

}
