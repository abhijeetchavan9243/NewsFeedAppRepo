package com.userservice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.userservice.models.Articles;
import com.userservice.services.ArticlesService;

@Service
public class ArticlesServiceImpl implements ArticlesService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Articles getArticles(String query) {
		return restTemplate.getForObject(
				"https://newsapi.org/v2/everything?q={query}&searchIn=title,description&pageSize=10&apiKey=4ba7ed9ed9a34afda8fb2221df7e74c3",
				Articles.class, query);
	}

}
