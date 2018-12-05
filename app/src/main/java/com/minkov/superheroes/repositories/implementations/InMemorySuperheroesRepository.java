package com.minkov.superheroes.repositories.implementations;

import com.minkov.superheroes.entities.Superhero;
import com.minkov.superheroes.repositories.SuperheroesRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemorySuperheroesRepository implements SuperheroesRepository {
    private static List<Superhero> superheroes;
    static {
        superheroes = new ArrayList<>();
    }

    @Override
    public List<Superhero> findAll() {
        return superheroes;
    }
}
