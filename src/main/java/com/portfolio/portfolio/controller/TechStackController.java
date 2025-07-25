package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.entity.TechStack;
import com.portfolio.portfolio.entity.User;
import com.portfolio.portfolio.service.TechStackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/techstacks")
//@CrossOrigin(origins = "https://ishimwedivin.vercel.app")
public class TechStackController {

    @Autowired
    private TechStackService techStackService;

    // Create or Update Tech Stack
    @PostMapping
    public TechStack createOrUpdateTechStack(@RequestBody TechStack techStack) {
        return techStackService.saveTechStack(techStack);
    }

    // Get All Tech Stacks
    @GetMapping
    public List<TechStack> getAllTechStacks() {
        return techStackService.getAllTechStacks();
    }

    // Get Tech Stacks by User
    @GetMapping("/user/{userId}")
    public List<TechStack> getTechStacksByUser(@PathVariable Long userId) {
        User user = new User();
        user.setId(userId); // Fetch the user by ID
        return techStackService.getTechStacksByUser(user);
    }

    // Get Tech Stacks by Name
    @GetMapping("/search")
    public List<TechStack> getTechStacksByName(@RequestParam String name) {
        return techStackService.getTechStacksByName(name);
    }

    // Get Tech Stack by ID
    @GetMapping("/{id}")
    public TechStack getTechStackById(@PathVariable Long id) {
        return techStackService.getTechStackById(id);
    }

    // Delete Tech Stack by ID
    @DeleteMapping("/{id}")
    public void deleteTechStack(@PathVariable Long id) {
        techStackService.deleteTechStack(id);
    }
}
