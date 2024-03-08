package com.wrathcodes.restaurant.domain;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Customer extends GenericDomain {

    @Column(length = 50, nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer", orphanRemoval = true)
    private Collection<OrderItem> orders;

    @ManyToOne
    private TableCheck check;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<OrderItem> getOrders() {
        return orders;
    }

    public void setOrders(Collection<OrderItem> orders) {
        this.orders = orders;
    }

}
