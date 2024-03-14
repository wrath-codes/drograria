package com.wrathcodes.restaurant.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Restaurant extends GenericDomain {

    @Column(length = 50, nullable = false, unique = true)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
