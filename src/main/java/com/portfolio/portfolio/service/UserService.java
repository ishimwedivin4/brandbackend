package com.portfolio.portfolio.service;

import com.portfolio.portfolio.entity.User;
import com.portfolio.portfolio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Create or Update User
    public User saveUser(User user) {
        // Encode password if not already encoded
        if (!user.getPassword().startsWith("$2a$")) { // BCrypt encoded passwords start with $2a$
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        return userRepository.save(user);
    }

    // Get All Users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get User by Username
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Get User by Email
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Get User by ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Delete User by ID
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Simple login method (ONLY for manual testing; in production, Spring Security handles login)
    public String login(String username, String password) {
        Optional<User> userOptional = userRepository.findByUsername(username);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (passwordEncoder.matches(password, user.getPassword())) {
                return "Login successful. Role: " + user.getRole();
            } else {
                return "Invalid password";
            }
        } else {
            return "User not found";
        }
    }

    // Check if user has a specific role
    public boolean hasRole(User user, String role) {
        return user.getRole().name().equalsIgnoreCase(role);
    }
}

