package com.sunzehai.mywebsite.dao.impl;

import com.sunzehai.mywebsite.constant.SqlFileCons;
import com.sunzehai.mywebsite.dao.BaseDAO;
import com.sunzehai.mywebsite.dao.ViewCategoryArticleCountsDAO;
import com.sunzehai.mywebsite.model.ViewCategoryArticleCounts;
import com.sunzehai.mywebsite.util.JDBCUtils;
import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.util.List;

public class ViewCategoryArticleCountsDAOImpl extends BaseDAO<ViewCategoryArticleCounts> implements ViewCategoryArticleCountsDAO {

    @Override
    public List<ViewCategoryArticleCounts> findAll() {
        Connection conn = JDBCUtils.getConnection();
        List<ViewCategoryArticleCounts> result = getResultList(conn, SqlFileCons.VIEW_CATEGORY_ARTICLE_COUNTS_SEL_001);
        DbUtils.closeQuietly(conn);
        return result;
    }

    @Override
    public ViewCategoryArticleCounts findByCategoryId(Integer categoryId) {
        Connection conn = JDBCUtils.getConnection();
        ViewCategoryArticleCounts result = getResult(conn, SqlFileCons.VIEW_CATEGORY_ARTICLE_COUNTS_SEL_002, categoryId);
        DbUtils.closeQuietly(conn);
        return result;
    }
}
