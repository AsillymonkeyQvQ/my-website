package com.sunzehai.mywebsite.service.impl;

import com.sunzehai.mywebsite.dao.ArticleDao;
import com.sunzehai.mywebsite.dao.impl.ArticleDaoImpl;
import com.sunzehai.mywebsite.model.Article;
import com.sunzehai.mywebsite.service.ArticleService;

import java.util.List;

public class ArticleServiceImpl implements ArticleService {

    private ArticleDao dao = new ArticleDaoImpl();

    @Override
    public List<Article> findAll() {
        return dao.findAll();
    }

    @Override
    public Article findById(Integer id) {
        return dao.findById(id);
    }

    @Override
    public List<Article> findByCategoryId(Integer categoryId) {
        return dao.findByCategoryId(categoryId);
    }
}
