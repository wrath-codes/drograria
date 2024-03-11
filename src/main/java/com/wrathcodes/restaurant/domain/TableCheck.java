package com.wrathcodes.restaurant.domain;

import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class TableCheck extends GenericDomain {

    @Column(nullable = false)
    private Boolean closed;

    @Column(nullable = false, precision = 6, scale = 2)
    private BigDecimal total;

    @OneToMany
    @JoinColumn(nullable = false)
    private Collection<OrderItem> orders;

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

    public Collection<OrderItem> getOrders() {
        return orders;
    }

    public void setOrders(Collection<OrderItem> orders) {
        this.orders = orders;
    }
}
