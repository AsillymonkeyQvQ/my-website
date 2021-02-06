package com.sunzehai.mywebsite.servlet.initializer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class ServletContextInitializer extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		
//		ServletContext context = this.getServletContext();
//		
//		List<Category> categories;
//		try(CategoryDao categoryDao = new CategoryDao()) {
//			categories = categoryDao.findAll();
//		} catch (SQLException e) {
//			throw new RuntimeException("Get categories failed.", e);
//		}
//		context.setAttribute("categories", categories);
//		
//		List<Article> articles;
//		try(ArticleDao articleDao = new ArticleDao()) {
//			articles = articleDao.findAll();
//		} catch (SQLException e) {
//			throw new RuntimeException("Get articles failed.", e);
//		}
//		context.setAttribute("articles", articles);
		
	}
	
}
