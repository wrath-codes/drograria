package com.wrathcodes.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.wrathcodes.restaurant.dao.RestaurantDAO;
import com.wrathcodes.restaurant.domain.Restaurant;

public class RestaurantDAOTest {

    @Test
    @Ignore
    public void save() {
        Restaurant restaurant = new Restaurant();

        // create a new restaurant
        restaurant.setName("McDonald's");

        // create restaurant DAO
        RestaurantDAO restaurantDAO = new RestaurantDAO();
        restaurantDAO.save(restaurant);

    }

    @Test
    // @Ignore
    public void list() {
        RestaurantDAO restaurantDAO = new RestaurantDAO();
        List<Restaurant> result = restaurantDAO.list();

        // print the result
        System.err.println("Total of restaurants: " + result.size());
        for (Restaurant restaurant : result) {
            System.err.println(restaurant.getName());
        }
    }

}
