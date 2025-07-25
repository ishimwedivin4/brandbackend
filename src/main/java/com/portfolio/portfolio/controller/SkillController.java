package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.entity.Skill;
import com.portfolio.portfolio.entity.User;
import com.portfolio.portfolio.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skills")
//@CrossOrigin(origins = "https://ishimwedivin.vercel.app")
public class SkillController {

    @Autowired
    private SkillService skillService;

    // Create or Update Skill
    @PostMapping
    public Skill createOrUpdateSkill(@RequestBody Skill skill) {
        return skillService.saveSkill(skill);
    }

    // Get All Skills
    @GetMapping
    public List<Skill> getAllSkills() {
        return skillService.getAllSkills();
    }

    // Get Skills by User
    @GetMapping("/user/{userId}")
    public List<Skill> getSkillsByUser(@PathVariable Long userId) {
        User user = new User();
        user.setId(userId); // Fetch the user by ID
        return skillService.getSkillsByUser(user);
    }

    // Get Skills by Level
    @GetMapping("/level/{level}")
    public List<Skill> getSkillsByLevel(@PathVariable String level) {
        return skillService.getSkillsByLevel(level);
    }

    // Get Skill by ID
    @GetMapping("/{id}")
    public Skill getSkillById(@PathVariable Long id) {
        return skillService.getSkillById(id);
    }

    // Delete Skill by ID
    @DeleteMapping("/{id}")
    public void deleteSkill(@PathVariable Long id) {
        skillService.deleteSkill(id);
    }

    // Get Skills by Name
    @GetMapping("/search")
    public List<Skill> getSkillsByName(@RequestParam String name) {
        return skillService.getSkillsByName(name);
    }
}
