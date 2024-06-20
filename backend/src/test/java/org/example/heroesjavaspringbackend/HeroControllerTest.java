package org.example.heroesjavaspringbackend;

import static org.mockito.Mockito.*;

import java.time.*;
import java.util.*;
import org.example.heroesjavaspringbackend.Controller.*;
import org.example.heroesjavaspringbackend.Domain.*;
import org.junit.jupiter.api.*;

public class HeroControllerTest {

    private final HeroService heroServiceMock = mock(HeroService.class);

    private final HeroController heroController = new HeroController(heroServiceMock, null, new HeroMapper());

    @Test
    public void getHeros_returnsHeros() {
        // Arrange
        final var heroes = List.of(new Hero("Superman", "Metropolis", 191, LocalDate.of(1938, 4, 18)),
                new Hero("Batman", "Gotham City", 188, LocalDate.of(1939, 5, 1)));

        // Act
        final var result = heroController.getHeroes();

        // Assert
        Assertions.assertEquals(result.size(), 2);
    }
}