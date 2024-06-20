package org.example.heroesjavaspringbackend;

import java.time.*;
import java.util.*;
import org.example.heroesjavaspringbackend.Domain.*;
import org.example.heroesjavaspringbackend.Repository.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.*;

@SpringBootApplication
public class HeroApplication {

    public static void main(String[] args) {
        SpringApplication.run(HeroApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @SuppressWarnings("null")
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("PUT", "DELETE", "GET", "POST");
            }
        };
    }

    @Bean
    @Profile("!test")
    public ApplicationRunner applicationRunner(HeroRepository heroRepository, HeroGangRepository heroGangRepository) {
        return args -> {
            final var listOfHeroes = List.of(
                    new Hero("Mickey Mouse", "Disneyland", 120, LocalDate.of(1928, 11, 18)),
                    new Hero("Donald Duck", "Duckburg", 100, LocalDate.of(1934, 6, 9)),
                    new Hero("Goofy Goof", "Goofyville", 200, LocalDate.of(1932, 5, 25)),
                    new Hero("Minnie Mouse", "Disneyland", 110, LocalDate.of(1928, 11, 18)),
                    new Hero("Daisy Duck", "Duckburg", 95, LocalDate.of(1940, 6, 9)),
                    new Hero("Pluto Dog", "Disneyland", 80, LocalDate.of(1930, 6, 1)),
                    new Hero("Simba Lion", "Pride Rock", 150, LocalDate.of(1994, 6, 15)),
                    new Hero("Mulan Fa", "China", 165, LocalDate.of(1998, 6, 19)),
                    new Hero("Aladin Boh", "Agrabah", 140, LocalDate.now()),
                    new Hero("Lion King", "Pride Lands", 200, LocalDate.now()),
                    new Hero("Winnie Puh", "Hundred Acre Wood", 90, LocalDate.now()));

            heroRepository.saveAll(listOfHeroes);

//            final var listOfHeroGangs = List.of(
//                    new HeroGang("Justice League",
//                            "Truth and Justice",
//                            "Hall of Justice",
//                            LocalDate.of(1934, 2, 11),
//                            listOfHeroes.subList(0, 3)),
//                    new HeroGang("Avengers",
//                            "To fight the foes no single superhero can withstand",
//                            "Stark Tower",
//                            LocalDate.of(1963, 9, 10),
//                            listOfHeroes.subList(3, 6)),
//                    new HeroGang("Lion King",
//                            "Hakuna Matata",
//                            "Pride Rock",
//                            LocalDate.of(1994, 6, 15),
//                            listOfHeroes.subList(6, 8)),
//                    new HeroGang("Winnie Puh",
//                            "Hundred Acre Wood",
//                            "Hundred Acre Wood",
//                            LocalDate.now(),
//                            listOfHeroes.subList(8, 11)));
//
//            heroGangRepository.saveAll(listOfHeroGangs);
        };
    }

    @Bean
    public RandomWrapper randomWrapper() {
        return new RandomWrapper();
    }

    @Bean
    public LocalDateWrapper localDateWrapper() {
        return new LocalDateWrapper();
    }

}
