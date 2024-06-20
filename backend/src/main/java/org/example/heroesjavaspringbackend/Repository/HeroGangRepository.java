package org.example.heroesjavaspringbackend.Repository;

import java.util.*;
import org.example.heroesjavaspringbackend.Domain.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.*;

@Repository
public interface HeroGangRepository extends CrudRepository<HeroGang, Long> {
    @SuppressWarnings("null")
    List<HeroGang> findAll();
}