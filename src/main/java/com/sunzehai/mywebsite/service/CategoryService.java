package com.sunzehai.mywebsite.service;

import com.sunzehai.mywebsite.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Category findById(Integer id);

    List<Category> findByParentId(Integer parentId);

}
