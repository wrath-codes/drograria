package com.wrathcodes.restaurant.domain;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Ingredient extends GenericDomain {

    @Column(length = 30, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String description;

    @ManyToMany(targetEntity = MenuItem.class, mappedBy = "ingredients")
    private Collection<MenuItem> menuItems;

    // Getters and Setters
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

    public Collection<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(Collection<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}
