package com.wrathcodes.restaurant.domain;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderCustomer extends GenericDomain {

    @Column(nullable = false, precision = 6, scale = 2)
    private BigDecimal orderTotal;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Customer customer;

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
