package org.example.heroesjavaspringbackend.Controller;

import org.example.heroesjavaspringbackend.Domain.*;
import org.springframework.stereotype.*;

@Component
public class HeroGangMapper {

    private final HeroMapper heroMapper;

    public HeroGangMapper(HeroMapper heroMapper) {
        this.heroMapper = heroMapper;
    }

    public HeroGangDto toDto(HeroGang heroGang) {
        return new HeroGangDto(1L, "name", "slogan", "meetingPoint", null, null);
    }
}