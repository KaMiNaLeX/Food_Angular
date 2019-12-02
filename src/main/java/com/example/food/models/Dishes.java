package com.example.food.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Dishes {
    private Long id;
    private String description;
    private Long mass;
    private String name;
    private String imgSource;
    private Long menuId;
    private Collection<ClientsDishes> clientsDishesById;
    private Menu menuByMenuId;
    private Collection<ShoppingCart> shoppingCartsById;

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
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "mass")
    public Long getMass() {
        return mass;
    }

    public void setMass(Long mass) {
        this.mass = mass;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Basic
    @Column(name = "imgSource")
    public String getImgSource() {
        return imgSource;
    }

    public void setImgSource(String imgSource) {
        this.imgSource = imgSource;
    }

    @Basic
    @Column(name = "menu_id")
    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dishes dishes = (Dishes) o;
        return Objects.equals(id, dishes.id) &&
                Objects.equals(description, dishes.description) &&
                Objects.equals(mass, dishes.mass) &&
                Objects.equals(name, dishes.name) &&
                Objects.equals(menuId, dishes.menuId) &&
                Objects.equals(imgSource, dishes.imgSource);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, mass, name, imgSource, menuId);
    }

    @OneToMany(mappedBy = "dishesByDishId")
    @JsonIgnore
    public Collection<ClientsDishes> getClientsDishesById() {
        return clientsDishesById;
    }

    @JsonIgnore
    public void setClientsDishesById(Collection<ClientsDishes> clientsDishesById) {
        this.clientsDishesById = clientsDishesById;
    }

    @ManyToOne
    @JoinColumn(name = "menu_id", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnore
    public Menu getMenuByMenuId() {
        return menuByMenuId;
    }

    @JsonIgnore
    public void setMenuByMenuId(Menu menuByMenuId) {
        this.menuByMenuId = menuByMenuId;
    }

    @OneToMany(mappedBy = "dishesByDishId")
    @JsonIgnore
    public Collection<ShoppingCart> getShoppingCartsById() {
        return shoppingCartsById;
    }

    @JsonIgnore
    public void setShoppingCartsById(Collection<ShoppingCart> shoppingCartsById) {
        this.shoppingCartsById = shoppingCartsById;
    }
}
