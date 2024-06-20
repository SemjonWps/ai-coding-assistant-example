package org.example.heroesjavaspringbackend.Controller;

import org.example.heroesjavaspringbackend.Domain.HeroGang;
import org.example.heroesjavaspringbackend.Domain.HeroGangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/heroGangs")
public class HeroGangController {

    private final HeroGangService heroGangService;
    private final HeroGangMapper heroGangMapper;

    @Autowired
    public HeroGangController(HeroGangService heroGangService, HeroGangMapper heroGangMapper) {
        this.heroGangService = heroGangService;
        this.heroGangMapper = heroGangMapper;
    }

    @GetMapping
    public List<HeroGangDto> getAllHeroGangs() {
        List<HeroGang> heroGangs = heroGangService.getAllHeroGangs();
        return heroGangs.stream().map(heroGangMapper::toDto).collect(Collectors.toList());
    }
}