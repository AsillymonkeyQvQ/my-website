package com.sunzehai.mywebsite.servlet.initializer;

import com.sunzehai.mywebsite.dao.ArticleDAO;
import com.sunzehai.mywebsite.dao.CategoryDAO;
import com.sunzehai.mywebsite.dao.impl.ArticleDAOImpl;
import com.sunzehai.mywebsite.dao.impl.CategoryDAOImpl;
import com.sunzehai.mywebsite.model.Article;
import com.sunzehai.mywebsite.model.Category;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.util.List;

public class ServletContextInitializer extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		ServletContext context = this.getServletContext();

		CategoryDAO categoryDao = new CategoryDAOImpl();
		List<Category> categories = categoryDao.findAll();
		context.setAttribute("categories", categories);

		ArticleDAO articleDao = new ArticleDAOImpl();
		List<Article> articles = articleDao.findAll();
		context.setAttribute("articles", articles);
	}
	
}
