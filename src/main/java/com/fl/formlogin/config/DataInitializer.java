package com.fl.formlogin.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fl.formlogin.model.User;
import com.fl.formlogin.repository.UserRepository;

@Configuration
public class DataInitializer {
    private static final Logger logger = LoggerFactory.getLogger(DataInitializer.class);

    @Bean
    CommandLineRunner initData(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            logger.info("Starting data initialization...");
            
            // Create admin user
            if (!userRepository.existsByUsername("admin")) {
                logger.info("Creating admin user...");
                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("admin123"));
                admin.setRole("ADMIN");
                userRepository.save(admin);
                logger.info("Admin user created successfully");
            } else {
                logger.info("Admin user already exists");
            }

            // Create regular user
            if (!userRepository.existsByUsername("user")) {
                logger.info("Creating regular user...");
                User user = new User();
                user.setUsername("user");
                user.setPassword(passwordEncoder.encode("user123"));
                user.setRole("USER");
                userRepository.save(user);
                logger.info("Regular user created successfully");
            } else {
                logger.info("Regular user already exists");
            }
            
            logger.info("Data initialization completed");
        };
    }
} 