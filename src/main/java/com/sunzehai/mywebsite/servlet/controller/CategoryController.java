package com.sunzehai.mywebsite.servlet.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunzehai.mywebsite.exception.NotFoundException;
import com.sunzehai.mywebsite.model.database.Article;
import com.sunzehai.mywebsite.model.database.Category;

@WebServlet("/category/*")
public class CategoryController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// Get parameter.
		String url = request.getRequestURL().toString();
		String param = url.substring(url.lastIndexOf("/") + 1);
		
		// Check parameter.
		@SuppressWarnings("unchecked")
		List<Category> categories = (List<Category>)request.getServletContext().getAttribute("categories");
		if(categories.stream().noneMatch(c -> c.getName().equals(param))) {
			throw new NotFoundException();
		}
		
		// Get specific category articles
		@SuppressWarnings("unchecked")
		List<Article> articles = (List<Article>)request.getServletContext().getAttribute("articles");
		request.setAttribute("articles", articles.stream()
				.filter(a -> a.getCategory().equals(param))
				.collect(Collectors.toList()));
		
		// Set attributes.
		request.setAttribute("category", param);
		
		// Request forwarding.
		request.getRequestDispatcher("/pages/category.jsp").forward(request, response);
	}

}
