package com.sunzehai.mywebsite.servlet.controller;

import com.sunzehai.mywebsite.exception.NotFoundException;
import com.sunzehai.mywebsite.model.Article;
import com.sunzehai.mywebsite.service.MarkdownService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/article/*")
public class ArticleController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// Get parameter.
		String url = request.getRequestURL().toString();
		String param = url.substring(url.lastIndexOf("/") + 1);

		// Check parameter.
		@SuppressWarnings("unchecked")
		List<Article> articles = (List<Article>)request.getServletContext().getAttribute("articles");
		if (articles.stream().noneMatch(a -> a.getId().toString().equals(param))) {
			throw new NotFoundException();
		}

		// Get specific article.
		Article article = articles.stream()
				                  .filter(a -> a.getId().toString().equals(param))
				                  .findFirst().get();

		// Get specific article html string.
		String html = MarkdownService.getInstance().getAticleHtml(request.getServletContext(), article);

		// Set attributes.
		request.setAttribute("article", article);
		request.setAttribute("html", html);

		// Request forwarding.
		request.getRequestDispatcher("/pages/article.jsp").forward(request, response);
	}

}
