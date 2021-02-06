package com.sunzehai.mywebsite.servlet.initializer;

import com.sunzehai.mywebsite.dao.ArticleDao;
import com.sunzehai.mywebsite.dao.CategoryDao;
import com.sunzehai.mywebsite.dao.impl.ArticleDaoImpl;
import com.sunzehai.mywebsite.dao.impl.CategoryDaoImpl;
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

		CategoryDao categoryDao = new CategoryDaoImpl();
		List<Category> categories = categoryDao.findAll();
		context.setAttribute("categories", categories);

		ArticleDao articleDao = new ArticleDaoImpl();
		List<Article> articles = articleDao.findAll();
		context.setAttribute("articles", articles);
	}
	
}
