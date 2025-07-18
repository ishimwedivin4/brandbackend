package com.portfolio.portfolio.service;

import com.portfolio.portfolio.entity.Article;
import com.portfolio.portfolio.entity.User;
import com.portfolio.portfolio.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    // Create or Update Article
    public Article saveArticle(Article article) {
        return articleRepository.save(article);
    }

    // Get All Articles
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    // Get Articles by User
    public List<Article> getArticlesByUser(User user) {
        return articleRepository.findByUser(user);
    }

    // Get Articles by Published Date
    public List<Article> getArticlesBeforeDate(LocalDateTime date) {
        return articleRepository.findByPublishedAtBefore(date);
    }

    // Find Article by ID
    public Optional<Article> getArticleById(Long id) {
        return articleRepository.findById(id);
    }

    // Delete Article by ID
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

    // Find Articles Published After a Specific Date
    public List<Article> getArticlesPublishedAfter(LocalDateTime date) {
        return articleRepository.findByPublishedAtAfter(date);
    }

    // Get Articles by Keyword in Title or Content
    public List<Article> getArticlesByKeyword(String keyword) {
        return articleRepository.findByTitleContainingOrContentContaining(keyword, keyword);
    }
}
