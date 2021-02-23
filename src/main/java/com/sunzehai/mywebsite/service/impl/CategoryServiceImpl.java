package com.sunzehai.mywebsite.service.impl;

import com.sunzehai.mywebsite.dao.CategoryDao;
import com.sunzehai.mywebsite.dao.impl.CategoryDaoImpl;
import com.sunzehai.mywebsite.model.Category;
import com.sunzehai.mywebsite.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private CategoryDao dao = new CategoryDaoImpl();

    @Override
    public List<Category> findAll() {
        return dao.findAll();
    }

    @Override
    public Category findById(Integer id) {
        return dao.findById(id);
    }

    @Override
    public List<Category> findByParentId(Integer parentId) {
        return dao.findByParentId(parentId);
    }

}
