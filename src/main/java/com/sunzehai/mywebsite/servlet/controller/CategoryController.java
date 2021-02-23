package com.sunzehai.mywebsite.servlet.controller;

import com.sunzehai.mywebsite.exception.NotFoundException;
import com.sunzehai.mywebsite.model.Article;
import com.sunzehai.mywebsite.model.Category;
import com.sunzehai.mywebsite.service.ArticleService;
import com.sunzehai.mywebsite.service.CategoryService;
import com.sunzehai.mywebsite.service.impl.ArticleServiceImpl;
import com.sunzehai.mywebsite.service.impl.CategoryServiceImpl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/category/*")
public class CategoryController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private CategoryService categoryService = new CategoryServiceImpl();

	private ArticleService articleService = new ArticleServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// Get parameter.
		String url = request.getRequestURL().toString();
		String param = url.substring(url.lastIndexOf("/") + 1);

		String subCategory = request.getParameter("subCategory");

		// Check parameter.
		@SuppressWarnings("unchecked")
		List<Category> categories = (List<Category>)request.getServletContext().getAttribute("categories");
		if(categories.stream().noneMatch(c -> c.getId().toString().equals(param))) {
			throw new NotFoundException();
		}

		// Get category
		Category category = categories.stream().filter(c -> c.getId().toString().equals(param)).findAny().get();

		// Get sub categories
		List<Category> subCategories = categoryService.findByParentId(category.getId());

		// Get current sub category
		Category currentSubCategory = null;
		if (subCategory != null) {
			currentSubCategory = subCategories.stream()
					.filter(c -> c.getId().equals(Integer.parseInt(subCategory)))
					.findAny().orElse(null);
		}

		// Get specific category articles
		@SuppressWarnings("unchecked")
		List<Article> articles = articleService.findByCategoryId(subCategory == null ? Integer.parseInt(param) : Integer.parseInt(subCategory));

		// Set attributes.
		request.setAttribute("category", category);
		request.setAttribute("articles", articles);
		request.setAttribute("subCategories", subCategories);
		request.setAttribute("currentSubCategory", currentSubCategory);

		// Request forwarding.
		request.getRequestDispatcher("/pages/category.jsp").forward(request, response);
	}

}
