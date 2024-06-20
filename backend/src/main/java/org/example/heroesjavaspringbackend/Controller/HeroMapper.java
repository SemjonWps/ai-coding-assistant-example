package org.example.heroesjavaspringbackend.Controller;

import org.example.heroesjavaspringbackend.Domain.*;
import org.springframework.stereotype.*;

@Component
public class HeroMapper {
    public HeroDto mapToDto(Hero hero) {
        return new HeroDto(hero.getId(),
                hero.getName(),
                hero.getBirthplace(),
                hero.getHeight(),
                hero.getDateOfBirth(),
                hero.getCreditcardNumber(),
                hero.getHeroGang() != null ? hero.getHeroGang().getName() : null
        );
    }

    public Hero mapToEntity(HeroDto heroDto) {
        return new Hero(heroDto.name(),
                heroDto.birthplace(),
                heroDto.height(),
                heroDto.dateOfBirth(),
                heroDto.creditcardNumber());
    }
}