package org.example.heroesjavaspringbackend.Domain;

import org.example.heroesjavaspringbackend.Repository.HeroGangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroGangService {

    private final HeroGangRepository heroGangRepository;

    @Autowired
    public HeroGangService(HeroGangRepository heroGangRepository) {
        this.heroGangRepository = heroGangRepository;
    }

    public List<HeroGang> getAllHeroGangs() {
        return heroGangRepository.findAll();
    }
}