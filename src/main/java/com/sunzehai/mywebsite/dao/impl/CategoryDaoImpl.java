package com.sunzehai.mywebsite.dao.impl;

import com.sunzehai.mywebsite.constant.SqlFileCons;
import com.sunzehai.mywebsite.dao.CategoryDao;
import com.sunzehai.mywebsite.dao.CommonDao;
import com.sunzehai.mywebsite.model.Category;

import java.util.List;

public class CategoryDaoImpl implements CategoryDao {

    @Override
    public List<Category> findAll() {
        return CommonDao.instance().getResultList(Category.class, SqlFileCons.CATEGORY_SEL_001);
    }

    @Override
    public Category findById(Integer id) {
        List<Category> list = CommonDao.instance().getResultList(Category.class, SqlFileCons.CATEGORY_SEL_002, id);
        if (list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

}
