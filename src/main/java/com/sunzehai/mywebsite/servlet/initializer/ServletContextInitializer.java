package com.sunzehai.mywebsite.servlet.initializer;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.sunzehai.mywebsite.model.Article;
import com.sunzehai.mywebsite.model.Category;

public class ServletContextInitializer extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		
		ServletContext context = this.getServletContext();
		
		List<Category> categories = Arrays.asList(
			new Category(1, "LIFESTYLE", ""),
			new Category(2, "TECHNOLOGY", ""),
			new Category(3, "JAPANESE", ""),
			new Category(4, "ANIMATION", "")
		);
		context.setAttribute("categories", categories);
		
		List<Article> articles = Arrays.asList(
			new Article("ARTICLE0001", "午后的清澄庭园", "LIFESTYLE", "测试文本", 0, LocalDateTime.now()),
			new Article("ARTICLE0002", "秒速五厘米", "ANIMATION", "测试文本", 0, LocalDateTime.parse("2021-01-01T00:00:00")),
			new Article("ARTICLE0003", "代代木公园", "LIFESTYLE", "测试文本", 0, LocalDateTime.parse("2021-01-01T00:00:00")),
			new Article("ARTICLE0004", "树莓派", "TECHNOLOGY", "测试文本", 0, LocalDateTime.parse("2021-01-01T00:00:00")),
			new Article("ARTICLE0005", "花火大会", "LIFESTYLE", "测试文本", 0, LocalDateTime.parse("2021-01-01T00:00:00")),
			new Article("ARTICLE0006", "个人电脑", "TECHNOLOGY", "测试文本", 0, LocalDateTime.parse("2021-01-01T00:00:00")),
			new Article("ARTICLE0007", "トミカ", "JAPANESE", "测试文本", 0, LocalDateTime.parse("2021-01-01T00:00:00"))
		);
		context.setAttribute("articles", articles);
		
	}
	
}
