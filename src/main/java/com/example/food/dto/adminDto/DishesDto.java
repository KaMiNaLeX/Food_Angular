package com.example.food.dto.adminDto;

import java.io.Serializable;
import java.math.BigInteger;

public class DishesDto implements Serializable {
    private BigInteger id;
    private String description;
    private BigInteger mass;
    private String name;
    private String imgSource;
    private BigInteger menuId;

    public String getImgSource() {
        return imgSource;
    }

    public void setImgSource(String imgSource) {
        this.imgSource = imgSource;
    }

    public BigInteger getMenuId() {
        return menuId;
    }

    public void setMenuId(BigInteger menuId) {
        this.menuId = menuId;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
