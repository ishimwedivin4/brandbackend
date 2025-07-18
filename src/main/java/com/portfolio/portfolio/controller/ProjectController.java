package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.entity.Project;
import com.portfolio.portfolio.entity.User;
import com.portfolio.portfolio.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    // Create or Update Project
    @PostMapping
    public Project createOrUpdateProject(@RequestBody Project project) {
        return projectService.saveProject(project);
    }

    // Get All Projects
    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    // Get Projects by User
    @GetMapping("/user/{userId}")
    public List<Project> getProjectsByUser(@PathVariable Long userId) {
        User user = new User();
        user.setId(userId); // Fetch the user by ID
        return projectService.getProjectsByUser(user);
    }

    // Get Projects by Tech Stack
    @GetMapping("/techstack/{techStack}")
    public List<Project> getProjectsByTechStack(@PathVariable String techStack) {
        return projectService.getProjectsByTechStack(techStack);
    }

    // Get Project by ID
    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }

    // Delete Project by ID
    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
    }

    // Get Projects Linked to GitHub
    @GetMapping("/github/{githubLink}")
    public List<Project> getProjectsByGitHubLink(@PathVariable String githubLink) {
        return projectService.getProjectsByGitHubLink(githubLink);
    }
}
