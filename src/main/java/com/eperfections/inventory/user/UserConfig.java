package com.eperfections.inventory.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunnerUser(UserRepository userRepository){
        return args -> {
            User user = new User("Khurram Shehzad","Islamabad Pakistan","123456","admin","admin");
            userRepository.saveAll(List.of(user));
        };
    }
}
