package com.sunzehai.mywebsite.service.impl;

import com.sunzehai.mywebsite.dao.ViewCategoryArticleCountsDAO;
import com.sunzehai.mywebsite.dao.impl.ViewCategoryArticleCountsDAOImpl;
import com.sunzehai.mywebsite.model.ViewCategoryArticleCounts;
import com.sunzehai.mywebsite.service.ViewCategoryArticleCountsService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ViewCategoryArticleCountsServiceImpl implements ViewCategoryArticleCountsService {

    private ViewCategoryArticleCountsDAO dao = new ViewCategoryArticleCountsDAOImpl();

    @Override
    public Map<Integer, ViewCategoryArticleCounts> findAll() {
        List<ViewCategoryArticleCounts> list = dao.findAll();
        Map<Integer, ViewCategoryArticleCounts> result = list.stream().collect(Collectors.toMap(v -> v.getId(), v -> v));
        return result;
    }

}
