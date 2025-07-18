package com.portfolio.portfolio.entity;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
@Table(name = "skill")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String level; // Beginner, Intermediate, Expert

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // The user who owns this skill

    // Constructor, Getters and Setters
}

