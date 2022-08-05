package com.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.models.Articles;
import com.userservice.services.ArticlesService;

@RestController
@RequestMapping("/article")
@CrossOrigin("*")
public class ArticlesController {
	
	@Autowired
	private ArticlesService articlesService;
	
	@GetMapping("/{query}")
	public ResponseEntity<Articles> getBooks(@PathVariable("query") String query){
		Articles articles= articlesService.getArticles(query);
		return ResponseEntity.ok(articles);
	}

}
