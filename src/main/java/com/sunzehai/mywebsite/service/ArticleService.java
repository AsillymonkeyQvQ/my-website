package com.sunzehai.mywebsite.service;

import com.sunzehai.mywebsite.model.Article;

import java.util.List;

public interface ArticleService {

    List<Article> findAll();

    Article findById(Integer id);

    List<Article> findByCategoryId(Integer categoryId);

}
