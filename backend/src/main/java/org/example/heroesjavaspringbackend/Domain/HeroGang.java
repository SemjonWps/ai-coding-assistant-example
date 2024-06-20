package org.example.heroesjavaspringbackend.Domain;

import jakarta.persistence.*;
import java.time.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class HeroGang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "slogan", length = 100, nullable = false)
    private String slogan;

    @Column(name = "meeting_point", length = 100)
    private String meetingPoint;

    @Column(name = "founding_year", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate foundingYear;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "hero_gang_id")
    private List<Hero> heroes = new ArrayList<>();

    public HeroGang() {
    }

    public HeroGang(String name, String slogan, String meetingPoint, LocalDate foundingYear, List<Hero> heroes) {
        this.name = name;
        this.slogan = slogan;
        this.meetingPoint = meetingPoint;
        this.foundingYear = foundingYear;
        this.heroes = heroes;
    }
}
