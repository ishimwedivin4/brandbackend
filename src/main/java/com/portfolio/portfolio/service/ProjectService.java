package com.portfolio.portfolio.service;

import com.portfolio.portfolio.entity.Project;
import com.portfolio.portfolio.entity.User;
import com.portfolio.portfolio.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    // Create or Update Project
    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    // Get All Projects
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    // Get Projects by User
    public List<Project> getProjectsByUser(User user) {
        return projectRepository.findByUser(user);
    }

    // Get Projects by Tech Stack
    public List<Project> getProjectsByTechStack(String techStack) {
        return projectRepository.findByTechStackContaining(techStack);
    }

    // Get Project by ID
    public Project getProjectById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    // Delete Project by ID
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    // Get Projects Linked to Specific GitHub Link
    public List<Project> getProjectsByGitHubLink(String githubLink) {
        return projectRepository.findByGithubLinkContaining(githubLink);
    }
}
