package com.portfolio.portfolio.entity;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
@Table(name = "TechStack")
public class TechStack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // The user associated with this tech stack

    // Constructor, Getters and Setters
}

