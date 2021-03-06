package com.sunzehai.mywebsite.service.impl;

import com.sunzehai.mywebsite.dao.ArticleDAO;
import com.sunzehai.mywebsite.dao.ViewCategoryArticleCountsDAO;
import com.sunzehai.mywebsite.dao.impl.ArticleDAOImpl;
import com.sunzehai.mywebsite.dao.impl.ViewCategoryArticleCountsDAOImpl;
import com.sunzehai.mywebsite.model.Article;
import com.sunzehai.mywebsite.model.Pager;
import com.sunzehai.mywebsite.service.ArticleService;

import java.util.List;

public class ArticleServiceImpl implements ArticleService {

    private ArticleDAO dao = new ArticleDAOImpl();

    private ViewCategoryArticleCountsDAO viewCategoryArticleCountsDAO = new ViewCategoryArticleCountsDAOImpl();

    @Override
    public List<Article> findAll() {
        return dao.findAll();
    }

    @Override
    public Article findById(Integer id) {
        return dao.findById(id);
    }

    @Override
    public Pager<Article> findByCategoryId(Integer categoryId, Integer currentPage) {
        Pager<Article> pager = new Pager<>();
        pager.setPageSize(8);
        pager.setTotalRecord(viewCategoryArticleCountsDAO.findByCategoryId(categoryId).getCounts());
        pager.setTotalPage(pager.getTotalRecord() % pager.getPageSize() == 0 ? pager.getTotalRecord() / pager.getPageSize() : pager.getTotalRecord() / pager.getPageSize() + 1);
        pager.setCurrentPage(currentPage);

        int start = (pager.getCurrentPage() - 1) * pager.getPageSize();
        int rowCount = pager.getPageSize();
        List<Article> dataList = dao.findByCategoryId(categoryId, start, rowCount);
        pager.setDataList(dataList);

        return pager;
    }
}
