package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.entity.User;
import com.portfolio.portfolio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

        import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Create or Update User
    @PostMapping("/register")
    public User createOrUpdateUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    // Get All Users
    @GetMapping("/getusers")
    public List<User> getAllUsers() {
        System.out.println("Fetching all users...");
        return userService.getAllUsers();
    }


    // Get User by Username
    @GetMapping("/username/{username}")
    public Optional<User> getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    // Get User by Email
    @GetMapping("/email/{email}")
    public Optional<User> getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    // Get User by ID
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // Delete User by ID
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    // Login method
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        // Call the login service method
        return userService.login(username, password);
    }

    // Role checking method
    @PostMapping("/checkRole")
    public String checkRole(@RequestParam String username, @RequestParam String password, @RequestParam String role) {
        // First, login the user
        String loginResult = userService.login(username, password);

        // Check if login was successful
        if (loginResult.contains("Login successful")) {
            // Retrieve the user
            User user = userService.getUserByUsername(username).orElse(null);

            if (user != null) {
                // Check if the user has the role
                if (userService.hasRole(user, role)) {
                    return "User has the " + role + " role.";
                } else {
                    return "User does not have the " + role + " role.";
                }
            } else {
                return "User not found after successful login.";
            }
        } else {
            return loginResult;  // Return login failure message
        }
    }


}
