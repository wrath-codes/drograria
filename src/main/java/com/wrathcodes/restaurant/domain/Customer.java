package com.wrathcodes.restaurant.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Customer extends GenericDomain {

    @Column(length = 50, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(nullable = false)
    private RestaurantTable seatedAt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RestaurantTable getSeatedAt() {
        return seatedAt;
    }

    public void setSeatedAt(RestaurantTable seatedAt) {
        this.seatedAt = seatedAt;
    }

}
