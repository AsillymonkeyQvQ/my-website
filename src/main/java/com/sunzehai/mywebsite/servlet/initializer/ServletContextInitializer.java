package com.sunzehai.mywebsite.servlet.initializer;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.sunzehai.mywebsite.dao.ArticleDao;
import com.sunzehai.mywebsite.dao.CategoryDao;
import com.sunzehai.mywebsite.model.Article;
import com.sunzehai.mywebsite.model.Category;

public class ServletContextInitializer extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		
		ServletContext context = this.getServletContext();
		
		List<Category> categories;
		try(CategoryDao categoryDao = new CategoryDao()) {
			categories = categoryDao.findAll();
		} catch (SQLException e) {
			throw new RuntimeException("Get categories failed.", e);
		}
		context.setAttribute("categories", categories);
		
		List<Article> articles;
		try(ArticleDao articleDao = new ArticleDao()) {
			articles = articleDao.findAll();
		} catch (SQLException e) {
			throw new RuntimeException("Get articles failed.", e);
		}
		context.setAttribute("articles", articles);
		
	}
	
}
