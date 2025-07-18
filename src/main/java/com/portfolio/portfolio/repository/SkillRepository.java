package com.portfolio.portfolio.repository;

import com.portfolio.portfolio.entity.Skill;
import com.portfolio.portfolio.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
    List<Skill> findByUser(User user);  // Find skills by user
    List<Skill> findByLevel(String level);  // Find skills by level (Beginner, Intermediate, Expert)
    List<Skill> findByNameContaining(String name); // Find skills by partial name match
}
