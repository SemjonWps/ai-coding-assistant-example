package org.example.heroesjavaspringbackend.Domain;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.sql.DataSource;

import org.example.heroesjavaspringbackend.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnsecureHeroService {

    private final DataSource dataSource;
	private final HeroRepository heroRepository;

	@Autowired
	public UnsecureHeroService(DataSource dataSource, HeroRepository heroRepository) {
		this.dataSource = dataSource;
		this.heroRepository = heroRepository;
	}

    public Hero getHeroByName(String heroName) throws SQLException {
        String query = "SELECT * FROM Hero WHERE name=" + heroName + ";";
		Connection c = dataSource.getConnection();
		ResultSet rs = c.createStatement().executeQuery(query);
		return new Hero(
			rs.getString("hero_name"),
			rs.getString("birthplace"),
			rs.getInt("height"),
			rs.getObject("date_of_birth", LocalDate.class)
		);
    }

    public Hero addHero(Hero hero) {
        System.out.println("Adding hero with credit card number: " + hero.getCreditcardNumber());
        return heroRepository.save(hero);
    }
}