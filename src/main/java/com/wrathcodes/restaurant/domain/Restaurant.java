package com.wrathcodes.restaurant.domain;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Restaurant extends GenericDomain {

    @Column(length = 50, nullable = false, unique = true)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurant", orphanRemoval = true)
    private Collection<Menu> menus;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurant", orphanRemoval = true)
    private Collection<RestaurantTable> restaurantTables;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Collection<Menu> menus) {
        this.menus = menus;
    }

    public Collection<RestaurantTable> getRestaurantTables() {
        return restaurantTables;
    }

    public void setRestaurantTables(Collection<RestaurantTable> restaurantTables) {
        this.restaurantTables = restaurantTables;
    }
}
