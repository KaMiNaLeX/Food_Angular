package com.example.food.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Menu {
    private Long id;
    private String category;
    private Long cost;
    private Collection<Dishes> dishesById;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "category")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Basic
    @Column(name = "cost")
    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return Objects.equals(id, menu.id) &&
                Objects.equals(category, menu.category) &&
                Objects.equals(cost, menu.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, cost);
    }

    @OneToMany(mappedBy = "menuByMenuId")
    @JsonIgnore
    public Collection<Dishes> getDishesById() {
        return dishesById;
    }

    @JsonIgnore
    public void setDishesById(Collection<Dishes> dishesById) {
        this.dishesById = dishesById;
    }
}
