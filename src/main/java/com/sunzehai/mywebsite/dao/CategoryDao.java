package com.sunzehai.mywebsite.dao;

import com.sunzehai.mywebsite.model.Category;

import java.util.List;

public interface CategoryDao {

    List<Category> findAll();

    Category findById(Integer id);

}
