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

}