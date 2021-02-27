package com.sunzehai.mywebsite.dao.impl;

import com.sunzehai.mywebsite.constant.SqlFileCons;
import com.sunzehai.mywebsite.dao.ArticleDAO;
import com.sunzehai.mywebsite.dao.BaseDAO;
import com.sunzehai.mywebsite.model.Article;
import com.sunzehai.mywebsite.util.JDBCUtils;
import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.util.List;

public class ArticleDAOImpl extends BaseDAO<Article> implements ArticleDAO {

    @Override
    public List<Article> findAll() {
        Connection conn = JDBCUtils.getConnection();
        List<Article> result = getResultList(conn, SqlFileCons.ARTICLE_SEL_001);
        DbUtils.closeQuietly(conn);
        return result;
    }

    @Override
    public Article findById(Integer id) {
        Connection conn = JDBCUtils.getConnection();
        Article result = getResult(conn, SqlFileCons.ARTICLE_SEL_002, id);
        DbUtils.closeQuietly(conn);
        return result;
    }

    @Override
    public List<Article> findByCategoryId(Integer categoryId) {
        Connection conn = JDBCUtils.getConnection();
        List<Article> result = getResultList(conn, SqlFileCons.ARTICLE_SEL_003, categoryId, categoryId);
        DbUtils.closeQuietly(conn);
        return result;
    }
}
