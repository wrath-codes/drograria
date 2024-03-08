package com.wrathcodes.restaurant.domain;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Menu extends GenericDomain {

    @Column(length = 50, nullable = false, unique = true)
    private String name;

    @Column(length = 100, nullable = false)
    private String description;

    @Column(length = 50, nullable = false)
    private String season;

    @Column(nullable = false)
    private Boolean available;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menu", orphanRemoval = true)
    private Collection<MenuItem> menuItems;

    @ManyToOne
    @JoinColumn
    private Restaurant restaurant;

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

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Collection<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(Collection<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

}
