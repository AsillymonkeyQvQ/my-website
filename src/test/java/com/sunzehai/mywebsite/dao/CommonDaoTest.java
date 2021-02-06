package com.sunzehai.mywebsite.dao;

import com.sunzehai.mywebsite.constant.SqlFileCons;
import com.sunzehai.mywebsite.model.Article;
import com.sunzehai.mywebsite.model.Category;
import org.junit.Test;

import java.util.List;

public class CommonDaoTest {
	
	@Test
	public void testGetResultList1() {
		List<Category> categories = CommonDao.instance().getResultList(Category.class, SqlFileCons.CATEGORY_SEL_001);
		categories.forEach(System.out::println);
	}

	@Test
	public void testGetResultList2() {
		List<Article> articles = CommonDao.instance().getResultList(Article.class, SqlFileCons.ARTICLE_SEL_001);
		articles.forEach(System.out::println);
	}
	
}
