package com.sunzehai.mywebsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sunzehai.mywebsite.model.Article;
import com.sunzehai.mywebsite.util.DBUtil;

public class ArticleDao implements AutoCloseable {
	
	private Connection conn;
	
	private String sql;
	
	private PreparedStatement ptmt;
	
	private ResultSet rs;
	
	public ArticleDao() {
		conn = DBUtil.getInstance().getConnection();
	}
	
	public List<Article> findAll() throws SQLException {
		List<Article> articles = new ArrayList<>();
		
		sql = "SELECT id, title, category, description, stars, create_date FROM article ORDER BY id;";
		ptmt = conn.prepareStatement(sql);
		rs = ptmt.executeQuery();
		
		while(rs.next()) {
			Article article = new Article();		
			article.setId(rs.getString("id"));
			article.setTitle(rs.getString("title"));
			article.setCategory(rs.getString("category"));
			article.setDescription(rs.getString("description"));
			article.setStars(rs.getInt("stars"));
			article.setCreateDate(rs.getDate("create_date").toLocalDate());
			
			articles.add(article);
		}
		
		return articles;
	}
	
	public Article findById(String id) throws SQLException {
		Article article = new Article();
		
		sql = "SELECT id, title, category, description, stars, create_date FROM article WHERE id = ?;";
		ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, id);
		rs = ptmt.executeQuery();
		
		if (rs.next()) {
			article.setId(rs.getString("id"));
			article.setTitle(rs.getString("title"));
			article.setCategory(rs.getString("category"));
			article.setDescription(rs.getString("description"));
			article.setStars(rs.getInt("stars"));
			article.setCreateDate(rs.getDate("create_date").toLocalDate());
		}
		
		return article;
	}

	@Override
	public void close() throws SQLException {
		if (rs != null && !rs.isClosed()) {
			rs.close();
		}
		if (ptmt != null && !ptmt.isClosed()) {
			ptmt.close();
		}
		if (conn != null && !conn.isClosed()) {
			conn.close();
		}
	}

}
