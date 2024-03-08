package com.wrathcodes.restaurant.domain;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class RestaurantTable extends GenericDomain {

    @Column(nullable = false)
    private Integer number;

    @Column(nullable = false)
    private Boolean available;

    @Column(nullable = false)
    private Integer capacity;

    @ManyToOne
    private Restaurant restaurant;

    @OneToMany(mappedBy = "restaurantTable", cascade = CascadeType.ALL)
    private Collection<TableCheck> checks;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Collection<TableCheck> getChecks() {
        return checks;
    }

    public void setChecks(Collection<TableCheck> checks) {
        this.checks = checks;
    }

}
