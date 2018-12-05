package com.minkov.superheroes.repositories;

import com.minkov.superheroes.entities.Superhero;

import java.util.List;

public interface SuperheroesRepository {
    List<Superhero> findAll();
}
