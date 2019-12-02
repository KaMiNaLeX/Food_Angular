package com.example.food.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "shopping_cart", schema = "food_delivery", catalog = "")
public class ShoppingCart {
    private Long id;
    private Long dishId;
    private Long clientId;
    private Dishes dishesByDishId;
    private Clients clientsByClientId;

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
    @Column(name = "dish_id")
    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    @Basic
    @Column(name = "client_id")
    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCart that = (ShoppingCart) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(dishId, that.dishId) &&
                Objects.equals(clientId, that.clientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dishId, clientId);
    }

    @ManyToOne
    @JoinColumn(name = "dish_id", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnore
    public Dishes getDishesByDishId() {
        return dishesByDishId;
    }

    @JsonIgnore
    public void setDishesByDishId(Dishes dishesByDishId) {
        this.dishesByDishId = dishesByDishId;
    }

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnore
    public Clients getClientsByClientId() {
        return clientsByClientId;
    }

    @JsonIgnore
    public void setClientsByClientId(Clients clientsByClientId) {
        this.clientsByClientId = clientsByClientId;
    }
}
