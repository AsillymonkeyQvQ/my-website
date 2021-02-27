package com.sunzehai.mywebsite.service;

import com.sunzehai.mywebsite.model.ViewCategoryArticleCounts;

import java.util.Map;

public interface ViewCategoryArticleCountsService {

    Map<Integer, ViewCategoryArticleCounts> findAll();

}
