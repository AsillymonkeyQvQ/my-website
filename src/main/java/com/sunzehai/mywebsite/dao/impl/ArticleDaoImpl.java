package com.sunzehai.mywebsite.dao.impl;

import com.sunzehai.mywebsite.constant.SqlFileCons;
import com.sunzehai.mywebsite.dao.ArticleDao;
import com.sunzehai.mywebsite.dao.CommonDao;
import com.sunzehai.mywebsite.model.Article;

import java.util.List;

public class ArticleDaoImpl implements ArticleDao {

    @Override
    public List<Article> findAll() {
        return CommonDao.instance().getResultList(Article.class, SqlFileCons.ARTICLE_SEL_001);
    }

    @Override
    public Article findById(Integer id) {
        List<Article> articles = CommonDao.instance().getResultList(Article.class, SqlFileCons.ARTICLE_SEL_002, id);
        if (articles.size() == 0) {
            return null;
        }
        return articles.get(0);
    }

    @Override
    public List<Article> findByCategoryId(Integer categoryId) {
        return CommonDao.instance().getResultList(Article.class, SqlFileCons.ARTICLE_SEL_003, categoryId, categoryId);
    }
}
