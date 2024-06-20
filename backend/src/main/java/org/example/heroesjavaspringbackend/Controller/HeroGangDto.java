package org.example.heroesjavaspringbackend.Controller;

import java.util.List;

public record HeroGangDto(Long id,
        String name,
        String slogan,
        String meetingPoint,
        String foundingYear,
        List<HeroDto> heroes) {
}