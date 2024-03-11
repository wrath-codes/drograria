package com.wrathcodes.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.wrathcodes.restaurant.dao.CategoryDAO;
import com.wrathcodes.restaurant.domain.Category;

public class CategoryDAOTest {

    @Test
    @Ignore
    public void save() {
        // create a new category
        Category category = new Category();
        category.setName("Pizza");
        category.setDescription("All about pizza");

        // create category DAO
        CategoryDAO categoryDAO = new CategoryDAO();
        categoryDAO.save(category);
    }

    @Test
    public void list() {
        CategoryDAO categoryDAO = new CategoryDAO();
        List<Category> result = categoryDAO.list();

        // print the result
        System.err.println("Total of categories: " + result.size());
        for (Category category : result) {
            System.err.println(category.getName() + ": " + category.getDescription());

        }
    }

}
