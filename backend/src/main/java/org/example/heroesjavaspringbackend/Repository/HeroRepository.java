package org.example.heroesjavaspringbackend.Repository;

import java.util.*;
import org.example.heroesjavaspringbackend.Domain.*;
import org.springframework.data.repository.*;

public interface HeroRepository extends CrudRepository<Hero, Long> {

    @SuppressWarnings("null")
    Collection<Hero> findAll();

    Hero findTopByOrderByIdDesc();

    Collection<Hero> findByNameContaining(String name);
}