package com.sunzehai.mywebsite.model;

import java.time.LocalDate;

public class Article {
	
	private String id;
	
	private String title;
	
	private String category;
	
	private String description;
	
	private Integer stars;
	
	private LocalDate createDate;
	
	public Article() {
		
	}

	public Article(String id, String title, String category, String description, Integer stars, LocalDate createDate) {
		this.id = id;
		this.title = title;
		this.category = category;
		this.description = description;
		this.stars = stars;
		this.createDate = createDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStars() {
		return stars;
	}

	public void setStars(Integer stars) {
		this.stars = stars;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}
	
}