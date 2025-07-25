package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.entity.Article;
import com.portfolio.portfolio.entity.User;
import com.portfolio.portfolio.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/articles")
//@CrossOrigin(origins = "https://ishimwedivin.vercel.app")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    // Create or Update Article
    @PostMapping
    public Article createOrUpdateArticle(@RequestBody Article article) {
        return articleService.saveArticle(article);
    }

    // Get All Articles
    @GetMapping
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    // Get Articles by User
    @GetMapping("/user/{userId}")
    public List<Article> getArticlesByUser(@PathVariable Long userId) {
        User user = new User();
        user.setId(userId); // Fetch the user by ID or you can use a service
        return articleService.getArticlesByUser(user);
    }

    // Get Articles by Published Date
    @GetMapping("/before-date")
    public List<Article> getArticlesBeforeDate(@RequestParam LocalDateTime date) {
        return articleService.getArticlesBeforeDate(date);
    }

    // Get Article by ID
    @GetMapping("/{id}")
    public Optional<Article> getArticleById(@PathVariable Long id) {
        return articleService.getArticleById(id);
    }

    // Delete Article by ID
    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
    }

    // Get Articles Published After a Specific Date
    @GetMapping("/after-date")
    public List<Article> getArticlesPublishedAfter(@RequestParam LocalDateTime date) {
        return articleService.getArticlesPublishedAfter(date);
    }

    // Get Articles by Keyword in Title or Content
    @GetMapping("/search")
    public List<Article> getArticlesByKeyword(@RequestParam String keyword) {
        return articleService.getArticlesByKeyword(keyword);
    }
}
