package com.wrathcodes.restaurant.domain;

import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

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

    @Column(nullable = false)
    private Boolean kitchen;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Menu menu;

    @ManyToOne
    private Category category;

    @ManyToMany(targetEntity = Ingredient.class)
    private Collection<Ingredient> ingredients;

    @ManyToMany(targetEntity = OrderItem.class, mappedBy = "items")
    private Collection<OrderItem> orders;

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Boolean getKitchen() {
        return kitchen;
    }

    public void setKitchen(Boolean kitchen) {
        this.kitchen = kitchen;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Collection<Ingredient> getIngredient() {
        return ingredients;
    }

    public void setIngredient(Collection<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

    public void removeIngredient(Ingredient ingredient) {
        this.ingredients.remove(ingredient);
    }
}
