package com.userservice.models;

public class Articles {

	private Article[] articles;

	public Articles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Articles(Article[] articles) {
		super();
		this.articles = articles;
	}

	public Article[] getArticles() {
		return articles;
	}

	public void setArticles(Article[] articles) {
		this.articles = articles;
	}

}
