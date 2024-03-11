package com.wrathcodes.dao;

import org.junit.Test;

import com.wrathcodes.restaurant.dao.RestaurantDAO;
import com.wrathcodes.restaurant.domain.Restaurant;

public class RestaurantDAOTest {

    @Test
    public void save() {
        Restaurant restaurant = new Restaurant();

        // create a new restaurant
        restaurant.setName("Bob's Burgers");

        // create restaurant DAO
        RestaurantDAO restaurantDAO = new RestaurantDAO();
        restaurantDAO.save(restaurant);

    }

}
