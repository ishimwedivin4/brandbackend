package com.portfolio.portfolio.repository;

import com.portfolio.portfolio.entity.Article;
import com.portfolio.portfolio.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByUser(User user);  // Find articles by user
    List<Article> findByPublishedAtBefore(LocalDateTime date);  // Find articles published before a certain date

    // Add this method to find articles published after a certain date
    List<Article> findByPublishedAtAfter(LocalDateTime date);  // Find articles published after a certain date

    // Add this method to find articles by keyword in the title or content
    List<Article> findByTitleContainingOrContentContaining(String title, String content);  // Find articles by keyword in title or content


}
