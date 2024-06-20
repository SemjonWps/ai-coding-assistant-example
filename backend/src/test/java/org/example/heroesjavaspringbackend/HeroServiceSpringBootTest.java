package org.example.heroesjavaspringbackend;

import static org.assertj.core.api.Assertions.assertThat;

import org.example.heroesjavaspringbackend.Repository.*;
import org.example.heroesjavaspringbackend.Domain.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SuppressWarnings("unused")
@SpringBootTest
class HeroServiceSpringBootTest {

    @Mock
    private HeroRepository heroRepository;

    @Mock
    private RandomWrapper randomWrapper;

    @Mock
    private LocalDateWrapper localDateWrapper;

    @InjectMocks
    private HeroService heroService;

}