package com.wrathcodes.drograria.domain;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer extends GenericDomain {

    @Column(length = 50, nullable = false)
    private String name;

    @OneToOne
    private RestaurantTable restaurantTable;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer", orphanRemoval = true)
    private Collection<OrderItem> orders;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RestaurantTable getTable() {
        return restaurantTable;
    }

    public void setTable(RestaurantTable restaurantTable) {
        this.restaurantTable = restaurantTable;
    }

}
