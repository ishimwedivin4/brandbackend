package com.portfolio.portfolio.config;

import com.portfolio.portfolio.entity.Role;
import com.portfolio.portfolio.entity.User;
import com.portfolio.portfolio.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserInitializer {

    @Bean
    public CommandLineRunner createDefaultAdmin(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            // Check if the user already exists
            if (userRepository.findByUsername("divin").isEmpty()) {
                User admin = new User();
                admin.setUsername("divin");
                admin.setPassword(passwordEncoder.encode("123"));  // encode the password
                admin.setEmail("ishimwedivin2@auca.ac.rw");
                admin.setRole(Role.ADMIN);  // assuming you have an enum called Role with ADMIN

                userRepository.save(admin);
                System.out.println("Default admin user created.");
            } else {
                System.out.println("Default admin user already exists.");
            }
        };
    }
}
