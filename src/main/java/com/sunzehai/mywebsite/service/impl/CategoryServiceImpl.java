package com.sunzehai.mywebsite.service.impl;

import com.sunzehai.mywebsite.dao.CategoryDAO;
import com.sunzehai.mywebsite.dao.impl.CategoryDAOImpl;
import com.sunzehai.mywebsite.model.Category;
import com.sunzehai.mywebsite.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private CategoryDAO dao = new CategoryDAOImpl();

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
