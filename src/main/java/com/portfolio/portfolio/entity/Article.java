package com.portfolio.portfolio.entity;

import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private LocalDateTime publishedAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // The user who wrote the article

    // Constructor, Getters and Setters
}

