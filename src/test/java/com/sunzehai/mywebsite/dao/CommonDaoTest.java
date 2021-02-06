package com.sunzehai.mywebsite.dao;

import java.util.List;

import org.junit.Test;

import com.sunzehai.mywebsite.constant.SqlFileCons;
import com.sunzehai.mywebsite.model.Category;

public class CommonDaoTest {
	
	@Test
	public void testGetResultList() {
		List<Category> categories = CommonDao.instance().getResultList(Category.class, SqlFileCons.CATEGORY_SEL_001);
		categories.forEach(System.out::println);
	}
	
}
