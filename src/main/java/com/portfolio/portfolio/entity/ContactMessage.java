package com.portfolio.portfolio.entity;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
@Table(name = "contactmessages")
public class ContactMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String message;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true) // optional relationship
    private User user; // The user who sent the contact message, if applicable

    // Constructor, Getters and Setters
}

