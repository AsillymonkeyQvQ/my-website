package com.sunzehai.mywebsite.model;

import com.sunzehai.mywebsite.annotation.Column;

public class Category {

	@Column(name = "id")
	private Integer id;

	@Column(name = "parentId")
	private Integer parentId;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", parentId=" + parentId + ", name=" + name + ", description=" + description
				+ "]";
	}
	
}
