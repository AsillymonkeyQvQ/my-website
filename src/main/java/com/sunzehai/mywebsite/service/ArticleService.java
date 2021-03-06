package com.sunzehai.mywebsite.service;

import com.sunzehai.mywebsite.model.Article;
import com.sunzehai.mywebsite.model.Pager;

import java.util.List;

public interface ArticleService {

    List<Article> findAll();

    Article findById(Integer id);

    Pager<Article> findByCategoryId(Integer categoryId, Integer currentPage);

}
