package com.sunzehai.mywebsite.servlet.controller;

import com.sunzehai.mywebsite.exception.NotFoundException;
import com.sunzehai.mywebsite.model.Article;
import com.sunzehai.mywebsite.model.Category;
import com.sunzehai.mywebsite.model.Pager;
import com.sunzehai.mywebsite.model.ViewCategoryArticleCounts;
import com.sunzehai.mywebsite.service.ArticleService;
import com.sunzehai.mywebsite.service.CategoryService;
import com.sunzehai.mywebsite.service.ViewCategoryArticleCountsService;
import com.sunzehai.mywebsite.service.impl.ArticleServiceImpl;
import com.sunzehai.mywebsite.service.impl.CategoryServiceImpl;
import com.sunzehai.mywebsite.service.impl.ViewCategoryArticleCountsServiceImpl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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

	private ViewCategoryArticleCountsService viewCategoryArticleCountsService = new ViewCategoryArticleCountsServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// Get parameter.
		String url = request.getRequestURL().toString();
		String param = url.substring(url.lastIndexOf("/") + 1);

		String subCategoryParam = request.getParameter("subCategory");
		String currentPageParam = request.getParameter("currentPage");

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
		if (subCategoryParam != null) {
			currentSubCategory = subCategories.stream()
					.filter(c -> c.getId().equals(Integer.parseInt(subCategoryParam)))
					.findAny().orElse(null);
		}

		// Get specific category articles
		Integer categoryId = subCategoryParam == null ? Integer.parseInt(param) : Integer.parseInt(subCategoryParam);
		Integer currentPage = currentPageParam == null ? 1 : Integer.parseInt(currentPageParam);
		Pager<Article> pager = articleService.findByCategoryId(categoryId, currentPage);

		// Get category articles counts
		Map<Integer, ViewCategoryArticleCounts> viewCategoryArticleCountsMap = viewCategoryArticleCountsService.findAll();

		// Set attributes.
		request.setAttribute("category", category);
		request.setAttribute("pager", pager);
		request.setAttribute("subCategories", subCategories);
		request.setAttribute("currentSubCategory", currentSubCategory);
		request.setAttribute("viewCategoryArticleCountsMap", viewCategoryArticleCountsMap);

		// Request forwarding.
		request.getRequestDispatcher("/pages/category.jsp").forward(request, response);
	}

}
