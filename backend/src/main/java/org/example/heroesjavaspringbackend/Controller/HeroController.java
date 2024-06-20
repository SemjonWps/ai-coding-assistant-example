package org.example.heroesjavaspringbackend.Controller;

import java.util.*;
import org.example.heroesjavaspringbackend.Repository.*;
import org.example.heroesjavaspringbackend.Domain.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/heroes")
public class HeroController {
    private final HeroService heroService;
    private final HeroRepository heroRepository;
    private final HeroMapper mapper;

    @Autowired
    public HeroController(HeroService heroService, HeroRepository heroRepository, HeroMapper mapper) {
        this.heroService = heroService;
        this.heroRepository = heroRepository;
        this.mapper = mapper;
    }

    @GetMapping
    public List<HeroDto> getHeroes() {
        Collection<Hero> heroes = heroService.getHeroes();
        final var list = heroes.stream().map(mapper::mapToDto).toList();
        return list;
    }

    @GetMapping("/{id}")
    public HeroDto getHeroes(@PathVariable Long id) {
        final var hero = heroRepository.findById(id).orElse(null);
        return hero != null ? mapper.mapToDto(hero) : null;
    }

    @PostMapping
    public HeroDto createHero(@RequestBody HeroDto hero) {
        final var dto = mapper.mapToEntity(hero);
        return mapper.mapToDto(heroService.createHero(dto));
    }

    @DeleteMapping("/{id}")
    public void deleteHero(@PathVariable Long id) {
        heroService.deleteHero(id);
    }

    @PutMapping
    public HeroDto updateHero(@RequestBody HeroDto heroDto) {
        Optional<Hero> optionalHero = heroRepository.findById(heroDto.id());

        if (optionalHero.isPresent()) {
            final var hero = optionalHero.get();
            hero.setName(heroDto.name());
            hero.setBirthplace(heroDto.birthplace());
            hero.setHeight(heroDto.height());
            hero.setDateOfBirth(heroDto.dateOfBirth());
            return mapper.mapToDto(heroRepository.save(hero));
        } else {
            final var entity = mapper.mapToEntity(heroDto);
            return mapper.mapToDto(heroRepository.save(entity));
        }
    }

    @GetMapping("/")
    public Iterable<HeroDto> searchHeroes(@RequestParam String name) {
        return heroRepository.findByNameContaining(name).stream().map(mapper::mapToDto).toList();
    }

    @PostMapping("/generateHero")
    public HeroDto generateHero() {
        final var generatedHero = heroService.generateHero();
        heroRepository.save(generatedHero);
        return mapper.mapToDto(generatedHero);
    }

}