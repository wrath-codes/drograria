package com.wrathcodes.drograria.domain;

import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

@Entity
public class MenuItem extends GenericDomain {

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 140, nullable = false)
    private String description;

    @Column(nullable = false, precision = 6, scale = 2)
    private BigDecimal price;

    @Column(nullable = false)
    private Boolean available;

    @ManyToOne
    @JoinColumn
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn
    private Category category;

    @ManyToMany
    private Collection<Ingredient> ingredient;
}
