package org.example.heroesjavaspringbackend;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;

import org.example.heroesjavaspringbackend.Repository.*;
import org.example.heroesjavaspringbackend.Domain.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class HeroServiceTest {

    private final HeroRepository heroRepository = Mockito.mock(HeroRepository.class);

    private final HeroService heroService = new HeroService(heroRepository, new LocalDateWrapper(),
            new RandomWrapper());

    @Test
    void generateHeroName() {
        // Arrange
        final var heroNames = List.of("Mickey Mouse", "Donald Duck", "Goofy Goof");
        final var indexToFirstName = 1;
        final var indexToFamilyName = 2;

        // Act
        final var result = heroService.generateHeroName(heroNames, indexToFirstName, indexToFamilyName);

        // Assert
        assertThat(result).isEqualTo("Donald Goof");
    }

    @Test
    void generateHeroName_whenListIsEmpty_returnsJohnDoe() {
        // Arrange
        final var heroNames = Collections.<String>emptyList();
        final var indexToFirstName = 1;
        final var indexToFamilyName = 2;

        // Act
        final var result = heroService.generateHeroName(heroNames, indexToFirstName, indexToFamilyName);

        // Assert
        assertThat(result).isEqualTo("John Doe");
    }
}