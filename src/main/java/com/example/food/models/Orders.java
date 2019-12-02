package com.example.food.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Orders {
    private Long id;
    private Long clientId;
    private Long sum;
    private Timestamp timeOrder;
    private Collection<ClientsDishes> clientsDishesById;
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
    @Column(name = "client_id")
    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    @Basic
    @Column(name = "sum")
    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

    @Basic
    @Column(name = "time_order")
    public Timestamp getTimeOrder() {
        return timeOrder;
    }

    public void setTimeOrder(Timestamp timeOrder) {
        this.timeOrder = timeOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return Objects.equals(id, orders.id) &&
                Objects.equals(clientId, orders.clientId) &&
                Objects.equals(sum, orders.sum) &&
                Objects.equals(timeOrder, orders.timeOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientId, sum, timeOrder);
    }

    @OneToMany(mappedBy = "ordersByOrderId")
    @JsonIgnore
    public Collection<ClientsDishes> getClientsDishesById() {
        return clientsDishesById;
    }

    @JsonIgnore
    public void setClientsDishesById(Collection<ClientsDishes> clientsDishesById) {
        this.clientsDishesById = clientsDishesById;
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
