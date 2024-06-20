package org.example.heroesjavaspringbackend.Domain;

import jakarta.persistence.*;
import java.time.*;
import java.util.*;
import lombok.*;

@Entity
@Getter
@Setter
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hero_id", nullable = true)
    private Long id;

    @Column(name = "hero_name", length = 100, nullable = false)
    private String name;

    @Column(name = "birthplace", length = 100)
    private String birthplace;

    @Column(name = "height")
    private int height;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "creditcard_number", length = 16)
    private String creditcardNumber;

    @ManyToOne
    @JoinColumn(name = "hero_gang_id")
    private HeroGang heroGang;

    public Hero(String name, String birthplace, int height, LocalDate dateOfBirth) {
        this.name = name;
        this.birthplace = birthplace;
        this.height = height;
        this.dateOfBirth = dateOfBirth;
    }

    public Hero(String name, String birthplace, int height, LocalDate dateOfBirth, String creditcardNumber) {
        this.name = name;
        this.birthplace = birthplace;
        this.height = height;
        this.dateOfBirth = dateOfBirth;
        this.creditcardNumber = creditcardNumber;
    }

    public HeroGang getHeroGang() {
        return heroGang;
    }

    public void setHeroGang(HeroGang heroGang) {
        this.heroGang = heroGang;
    }

    @Deprecated
    protected Hero() {
        this.id = null;
        this.name = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Hero hero))
            return false;
        return Objects.equals(id, hero.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
