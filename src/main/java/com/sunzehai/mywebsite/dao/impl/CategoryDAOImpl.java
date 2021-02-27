package com.sunzehai.mywebsite.dao.impl;

import com.sunzehai.mywebsite.constant.SqlFileCons;
import com.sunzehai.mywebsite.dao.BaseDAO;
import com.sunzehai.mywebsite.dao.CategoryDAO;
import com.sunzehai.mywebsite.model.Category;
import com.sunzehai.mywebsite.util.JDBCUtils;
import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.util.List;

public class CategoryDAOImpl extends BaseDAO<Category> implements CategoryDAO {

    @Override
    public List<Category> findAll() {
        Connection conn = JDBCUtils.getConnection();
        List<Category> result = getResultList(conn, SqlFileCons.CATEGORY_SEL_001);
        DbUtils.closeQuietly(conn);
        return result;
    }

    @Override
    public Category findById(Integer id) {
        Connection conn = JDBCUtils.getConnection();
        Category result = getResult(conn, SqlFileCons.CATEGORY_SEL_002, id);
        DbUtils.closeQuietly(conn);
        return result;
    }

    @Override
    public List<Category> findByParentId(Integer parentId) {
        Connection conn = JDBCUtils.getConnection();
        List<Category> result = getResultList(conn, SqlFileCons.CATEGORY_SEL_003, parentId);
        DbUtils.closeQuietly(conn);
        return result;
    }
}
