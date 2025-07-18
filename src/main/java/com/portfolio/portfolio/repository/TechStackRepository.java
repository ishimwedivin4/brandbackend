package com.portfolio.portfolio.repository;

import com.portfolio.portfolio.entity.TechStack;
import com.portfolio.portfolio.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechStackRepository extends JpaRepository<TechStack, Long> {
    List<TechStack> findByUser(User user);  // Find tech stacks by user
    List<TechStack> findByNameContaining(String name);  // Find tech stacks by name (partial match)
}
