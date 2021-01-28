package com.sunzehai.mywebsite.model.database;

import java.time.LocalDateTime;

public class Article {
	
	private String id;
	
	private String title;
	
	private String category;
	
	private String description;
	
	private Integer stars;
	
	private LocalDateTime createDateTime;

	public Article(String id, String title, String category, String description, Integer stars, LocalDateTime createDateTime) {
		this.id = id;
		this.title = title;
		this.category = category;
		this.description = description;
		this.stars = stars;
		this.createDateTime = createDateTime;
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

	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}
	
}