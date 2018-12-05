package com.minkov.superheroes.services.implementations;

import com.minkov.superheroes.dtos.SuperheroItemDto;
import com.minkov.superheroes.entities.Superhero;
import com.minkov.superheroes.repositories.SuperheroesRepository;
import com.minkov.superheroes.services.SuperheroesService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SuperheroesServiceImpl implements SuperheroesService {
    private final SuperheroesRepository superheroesRepository;
    private final ModelMapper mapper;

    public SuperheroesServiceImpl(
            SuperheroesRepository superheroesRepository,
            ModelMapper mapper
    ) {
        this.superheroesRepository = superheroesRepository;
        this.mapper = mapper;
    }

    @Override
    public List<SuperheroItemDto> getAll() {
        return superheroesRepository.findAll()
                .stream()
                .map(entity -> mapper.map(entity, SuperheroItemDto.class))
                .collect(Collectors.toList());
    }
}
