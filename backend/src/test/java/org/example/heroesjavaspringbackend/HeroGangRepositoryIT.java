package org.example.heroesjavaspringbackend;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.*;
import java.time.*;
import java.util.*;
import org.example.heroesjavaspringbackend.Domain.*;
import org.example.heroesjavaspringbackend.Repository.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.test.context.*;
import org.springframework.transaction.annotation.*;

@SpringBootTest
@ActiveProfiles("test")
public class HeroGangRepositoryIT {

    @Autowired
    private HeroGangRepository heroGangRepository;

    @Autowired
    private HeroRepository heroRepository;

    @Transactional
    @Test
    public void testFindAll() throws ParseException {
        // Arrange
        HeroGang heroGang1 = new HeroGang("Justice League", "Truth and Justice", "Hall of Justice",
                LocalDate.of(2024, 1, 1), Collections.emptyList());

        List<Hero> heroes = List.of(
                new Hero("Mickey Mouse", "Disneyland", 120, LocalDate.of(1928, 11, 18)),
                new Hero("Donald Duck", "Duckburg", 100, LocalDate.of(1934, 6, 9),
                        "1234567890123456"));

        heroRepository.saveAll(heroes);

        HeroGang heroGang2 = new HeroGang("Avengers", "To fight the foes no single superhero can withstand",
                "Stark Tower", LocalDate.of(2024, 1, 2), heroes);

        heroGangRepository.save(heroGang1);
        heroGangRepository.save(heroGang2);

        // Act
        List<HeroGang> foundHeroGangs = heroGangRepository.findAll();

        // Assert
        assertThat(foundHeroGangs).hasSize(2);
        assertThat(foundHeroGangs).usingRecursiveFieldByFieldElementComparator()
                .containsExactlyInAnyOrder(heroGang1, heroGang2);
    }
}