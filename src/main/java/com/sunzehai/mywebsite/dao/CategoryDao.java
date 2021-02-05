package com.sunzehai.mywebsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sunzehai.mywebsite.model.Category;
import com.sunzehai.mywebsite.util.JdbcUtils;

public class CategoryDao implements AutoCloseable {
	
	private final Connection conn;
	
	private String sql;
	
	private PreparedStatement ptmt;
	
	private ResultSet rs;
	
	public CategoryDao() {
		conn = JdbcUtils.getConnection();
	}
	
	public List<Category> findAll() throws SQLException {
		List<Category> categories = new ArrayList<>();
		
		sql = "SELECT id, name, description FROM category;";
		ptmt = conn.prepareStatement(sql);
		rs = ptmt.executeQuery();
		
		while(rs.next()) {
			Category category = new Category();
			category.setId(rs.getInt("id"));
			category.setName(rs.getString("name"));
			category.setDescription(rs.getString("description"));
			
			categories.add(category);
		}
		
		return categories;
	}

	@Override
	public void close() throws SQLException {
		if (rs != null && !rs.isClosed()) {
			rs.close();
		}
		if (ptmt != null && !ptmt.isClosed()) {
			ptmt.close();
		}
		if (conn != null && conn.isClosed()) {
			conn.close();
		}
	}
	
}
