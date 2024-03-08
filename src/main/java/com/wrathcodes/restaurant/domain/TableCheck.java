package com.wrathcodes.restaurant.domain;

import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class TableCheck extends GenericDomain {

    @OneToMany(mappedBy = "check", cascade = CascadeType.ALL)
    private Collection<Customer> customers;

    @Column(nullable = false)
    private Boolean closed;

    @Column(nullable = false, precision = 6, scale = 2)
    private BigDecimal total;

    @ManyToOne
    private RestaurantTable restaurantTable;

    public Collection<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Collection<Customer> customers) {
        this.customers = customers;
    }

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public RestaurantTable getRestaurantTable() {
        return restaurantTable;
    }

    public void setRestaurantTable(RestaurantTable restaurantTable) {
        this.restaurantTable = restaurantTable;
    }

}
