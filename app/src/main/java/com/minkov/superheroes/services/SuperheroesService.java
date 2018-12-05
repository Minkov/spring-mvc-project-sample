package com.minkov.superheroes.services;

import com.minkov.superheroes.dtos.SuperheroItemDto;

import java.util.List;

public interface SuperheroesService {
    List<SuperheroItemDto> getAllSuperheroes();
}
