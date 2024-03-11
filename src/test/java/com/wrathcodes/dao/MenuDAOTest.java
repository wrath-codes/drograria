package com.wrathcodes.dao;

import org.junit.Test;

import com.wrathcodes.restaurant.dao.MenuDAO;
import com.wrathcodes.restaurant.dao.RestaurantDAO;
import com.wrathcodes.restaurant.domain.Menu;
import com.wrathcodes.restaurant.domain.Restaurant;

public class MenuDAOTest {

    @Test
    public void save() {

        // get restaurant
        Long restaurantCode = 1L;
        Restaurant restaurant = new RestaurantDAO().search(restaurantCode);

        // create a new menu
        Menu menu = new Menu();
        menu.setName("Last Supper");
        menu.setDescription("The last supper you will ever have");
        menu.setSeason("Winter");
        menu.setAvailable(true);
        menu.setRestaurant(restaurant);

        // create menu DAO
        MenuDAO menuDAO = new MenuDAO();
        menuDAO.save(menu);
    }

}
