package com.sunzehai.mywebsite.servlet.initializer;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.sunzehai.mywebsite.model.database.Category;

public class ServletContextInitializer extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		
		ServletContext context = this.getServletContext();
		
		List<Category> categorys = Arrays.asList(
			new Category(1, "LIFESTYLE", ""),
			new Category(2, "TECHNOLOGY", ""),
			new Category(3, "JAPANESE", ""),
			new Category(4, "ANIMATION", "")
		);
		
		context.setAttribute("categorys", categorys);
		
	}
	
}
