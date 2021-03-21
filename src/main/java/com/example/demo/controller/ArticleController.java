package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArticleController {
    @GetMapping("/articles/new")
    public String newArticle() {
        return "articles/new";
    }
}
