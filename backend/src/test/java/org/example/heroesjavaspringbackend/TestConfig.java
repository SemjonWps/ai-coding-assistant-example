package org.example.heroesjavaspringbackend;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@Configuration
@Profile("test")
public class TestConfig {

    @Bean
    public ApplicationRunner applicationRunner2() {
        return args -> {
            // Your test initialization code here
        };
    }
}