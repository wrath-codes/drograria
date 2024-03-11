package com.wrathcodes.dao;

import org.junit.Test;

import com.wrathcodes.restaurant.dao.CategoryDAO;
import com.wrathcodes.restaurant.domain.Category;

public class CategoryDAOTest {

    @Test
    public void save() {
        // create a new category
        Category category = new Category();
        category.setName("Burgers");
        category.setDescription("All types of burgers");

        // create category DAO
        CategoryDAO categoryDAO = new CategoryDAO();
        categoryDAO.save(category);
    }

}
