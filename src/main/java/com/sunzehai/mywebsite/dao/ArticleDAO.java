package com.sunzehai.mywebsite.dao;

import com.sunzehai.mywebsite.model.Article;
import com.sunzehai.mywebsite.model.Pager;

import java.util.List;

public interface ArticleDAO {

    List<Article> findAll();

    Article findById(Integer id);

    List<Article> findByCategoryId(Integer categoryId, Integer start, Integer rowCount);

}
