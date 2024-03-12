package com.wrathcodes.restaurant.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TableCheck extends GenericDomain {

    @Column(nullable = false)
    private Boolean closed;

    @Column(nullable = false, precision = 6, scale = 2)
    private BigDecimal checkTotal;

    @ManyToOne
    @JoinColumn(nullable = false)
    private RestaurantTable restaurantTable;

    public RestaurantTable getRestaurantTable() {
        return restaurantTable;
    }

    public void setRestaurantTable(RestaurantTable restaurantTable) {
        this.restaurantTable = restaurantTable;
    }

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public BigDecimal getTotal() {
        return checkTotal;
    }

    public void setTotal(BigDecimal checkTotal) {
        this.checkTotal = checkTotal;
    }

}
