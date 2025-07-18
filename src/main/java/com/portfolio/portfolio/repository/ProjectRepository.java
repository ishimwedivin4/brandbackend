package com.portfolio.portfolio.repository;

import com.portfolio.portfolio.entity.Project;
import com.portfolio.portfolio.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByUser(User user);  // Find projects by user
    List<Project> findByTechStackContaining(String tech);  // Find projects with a specific tech stack
    List<Project> findByGithubLinkContaining(String githubLink);  // Find projects with a specific GitHub link
}
