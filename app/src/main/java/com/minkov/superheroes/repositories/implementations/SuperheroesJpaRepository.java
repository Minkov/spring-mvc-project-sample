package com.minkov.superheroes.repositories.implementations;

import com.minkov.superheroes.entities.Superhero;
import com.minkov.superheroes.repositories.SuperheroesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperheroesJpaRepository extends JpaRepository<Superhero, Long>, SuperheroesRepository {
}
