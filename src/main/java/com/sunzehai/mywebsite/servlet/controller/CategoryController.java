package com.sunzehai.mywebsite.servlet.controller;

import com.sunzehai.mywebsite.exception.NotFoundException;
import com.sunzehai.mywebsite.model.Article;
import com.sunzehai.mywebsite.model.Category;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		if(categories.stream().noneMatch(c -> c.getId().toString().equals(param))) {
			throw new NotFoundException();
		}

		// Get category
		Category category = categories.stream().filter(c -> c.getId().toString().equals(param)).findAny().get();

		// Get specific category articles
		@SuppressWarnings("unchecked")
		List<Article> articles = (List<Article>)request.getServletContext().getAttribute("articles");
		request.setAttribute("articles", articles.stream()
				.filter(a -> a.getCategoryId().toString().equals(param))
				.collect(Collectors.toList()));

		// Set attributes.
		request.setAttribute("category", category);

		// Request forwarding.
		request.getRequestDispatcher("/pages/category.jsp").forward(request, response);
	}

}
