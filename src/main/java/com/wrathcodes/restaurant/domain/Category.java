package com.wrathcodes.restaurant.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Category extends GenericDomain {

    @Column(length = 50, nullable = false, unique = true)
    private String name;

    @Column(length = 100, nullable = false)
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
