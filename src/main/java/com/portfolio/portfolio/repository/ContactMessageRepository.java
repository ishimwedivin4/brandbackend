package com.portfolio.portfolio.repository;

import com.portfolio.portfolio.entity.ContactMessage;
import com.portfolio.portfolio.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactMessageRepository extends JpaRepository<ContactMessage, Long> {
    List<ContactMessage> findByUser(User user);  // Find messages by user
    List<ContactMessage> findByEmail(String email);  // Find messages by email
}
