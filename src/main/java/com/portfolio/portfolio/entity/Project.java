package com.portfolio.portfolio.entity;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String techStack; // e.g., "Spring Boot, React"
    private String githubLink;
    private String liveDemoLink;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // The user who created this project

    // Constructor, Getters and Setters
}
