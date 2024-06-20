package org.example.heroesjavaspringbackend.Controller;

import java.time.*;
import org.springframework.lang.*;

public record HeroDto(Long id,
                      String name,
                      String birthplace,
                      int height,
                      LocalDate dateOfBirth,
                      @Nullable String creditcardNumber,
                      @Nullable String heroGangName) {
}