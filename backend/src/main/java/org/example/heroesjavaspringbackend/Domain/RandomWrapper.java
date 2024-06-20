package org.example.heroesjavaspringbackend.Domain;

import java.util.*;

public class RandomWrapper {
    private final Random random = new Random();

    public int nextInt(int bound) {
        return random.nextInt(bound);
    }
}