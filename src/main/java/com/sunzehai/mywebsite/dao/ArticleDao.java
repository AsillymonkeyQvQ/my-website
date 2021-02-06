package com.sunzehai.mywebsite.dao;

import com.sunzehai.mywebsite.model.Article;

import java.util.List;

public interface ArticleDao {

    List<Article> findAll();

    Article findById(Integer id);

}
