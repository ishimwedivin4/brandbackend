package com.portfolio.portfolio.service;

import com.portfolio.portfolio.entity.Skill;
import com.portfolio.portfolio.entity.User;
import com.portfolio.portfolio.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    // Create or Update Skill
    public Skill saveSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    // Get All Skills
    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    // Get Skills by User
    public List<Skill> getSkillsByUser(User user) {
        return skillRepository.findByUser(user);
    }

    // Get Skills by Level (Beginner, Intermediate, Expert)
    public List<Skill> getSkillsByLevel(String level) {
        return skillRepository.findByLevel(level);
    }

    // Get Skill by ID
    public Skill getSkillById(Long id) {
        return skillRepository.findById(id).orElse(null);
    }

    // Delete Skill by ID
    public void deleteSkill(Long id) {
        skillRepository.deleteById(id);
    }

    // Get Skills by Name (partial match)
    public List<Skill> getSkillsByName(String name) {
        return skillRepository.findByNameContaining(name);
    }
}
