package com.portfolio.portfolio.service;

import com.portfolio.portfolio.entity.TechStack;
import com.portfolio.portfolio.entity.User;
import com.portfolio.portfolio.repository.TechStackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechStackService {

    @Autowired
    private TechStackRepository techStackRepository;

    // Create or Update Tech Stack
    public TechStack saveTechStack(TechStack techStack) {
        return techStackRepository.save(techStack);
    }

    // Get All Tech Stacks
    public List<TechStack> getAllTechStacks() {
        return techStackRepository.findAll();
    }

    // Get Tech Stacks by User
    public List<TechStack> getTechStacksByUser(User user) {
        return techStackRepository.findByUser(user);
    }

    // Get Tech Stacks by Name (partial match)
    public List<TechStack> getTechStacksByName(String name) {
        return techStackRepository.findByNameContaining(name);
    }

    // Get Tech Stack by ID
    public TechStack getTechStackById(Long id) {
        return techStackRepository.findById(id).orElse(null);
    }

    // Delete Tech Stack by ID
    public void deleteTechStack(Long id) {
        techStackRepository.deleteById(id);
    }
}
