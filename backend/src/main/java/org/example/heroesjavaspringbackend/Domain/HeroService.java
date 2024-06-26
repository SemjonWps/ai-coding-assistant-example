package org.example.heroesjavaspringbackend.Domain;

import java.util.*;
import java.util.stream.*;
import org.example.heroesjavaspringbackend.Repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class HeroService {
    private final HeroRepository heroRepository;
    private final LocalDateWrapper localDateWrapper;

    private final RandomWrapper randomWrapper;

    @Autowired
    public HeroService(HeroRepository heroRepository, LocalDateWrapper localDateWrapper, RandomWrapper randomWrapper) {
        this.heroRepository = heroRepository;
        this.localDateWrapper = localDateWrapper;
        this.randomWrapper = randomWrapper;
    }

    public Collection<Hero> getHeroes() {

        return heroRepository.findAll();
    }

    public Hero createHero(Hero hero) {
        return heroRepository.save(hero);
    }

    public boolean checkNoNameExistsTwiceInDatabase() {
        final var heroes = heroRepository.findAll();
        // split the names of the heroes by space
        final var names = heroes.stream().map(Hero::getName).map(name -> name.split(" ")).flatMap(Arrays::stream)
                .collect(Collectors.toSet());

        // check if there are any duplicates
        return names.size() == heroes.size() * 2;
    }

    public boolean checkEveryNameConsistOfTwoWords() {
        final var heroes = heroRepository.findAll();
        final var names = heroes.stream().map(Hero::getName)
                .map(name -> name.split(" ")).toList();
        return names.stream().allMatch(name -> name.length == 2);
    }

    public void updateHero(Long id, String name) {
        final var hero = heroRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Hero with id" + id + "not found"));
        hero.setName(name);
        heroRepository.save(hero);
    }

    public Hero updateHeroName(Long id, String newName) {
        final var hero = heroRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Hero with id " + id + " not found"));
        hero.setName(newName);
        heroRepository.save(hero);
        return hero;
    }

    public void deleteHero(Long id) {
        heroRepository.deleteById(id);
    }

    public Hero getLatestHero() {
        return heroRepository.findTopByOrderByIdDesc();
    }

    public void buggyMethod() {
        Hero hero = null;
        String heroName = hero.getName();
    }

    public Hero generateHero() {
        final var existingHeroNames = heroRepository.findAll().stream().map(Hero::getName).toList();
        final var indexFirstName = randomWrapper.nextInt(existingHeroNames.size());
        final var indexLastName = randomWrapper.nextInt(existingHeroNames.size());
        // final var name = generateHeroName(existingHeroNames, indexFirstName);
        final var name = generateHeroName(existingHeroNames, indexFirstName, indexLastName);
        return new Hero(name, "Earth", 180, localDateWrapper.now());
    }

    /**
     * Generates a hero name by combining the first name and family name from the
     * given list of hero names.
     * If the list is empty, the default name "John Doe" is returned.
     *
     * @param heroNames         the list of hero names
     * @param indexToFirstName  the index of the hero name to use for the first name
     * @param indexToFamilyName the index of the hero name to use for the family
     *                          name
     * @return the generated hero name
     */
    public String generateHeroName(List<String> heroNames, int indexToFirstName, int indexToFamilyName) {
        if (heroNames.isEmpty()) {
            return "John Doe";
        }

        String firstName = heroNames.get(indexToFirstName).split(" ")[0];
        String familyName = heroNames.get(indexToFamilyName).split(" ")[1];

        return firstName + " " + familyName;
    }
}