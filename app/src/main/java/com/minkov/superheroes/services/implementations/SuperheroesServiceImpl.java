package com.minkov.superheroes.services.implementations;

import com.minkov.superheroes.dtos.SuperheroItemDto;
import com.minkov.superheroes.entities.Superhero;
import com.minkov.superheroes.services.SuperheroesService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SuperheroesServiceImpl implements SuperheroesService {
    private static List<Superhero> superheroes;

    static {
        superheroes = new ArrayList<>();
        superheroes.add(new Superhero(1, "Batman", "Bruce Wayne"));
    }

    private final ModelMapper mapper;

    public SuperheroesServiceImpl(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<SuperheroItemDto> getAll() {
        return superheroes.stream()
                .map(entity -> mapper.map(entity, SuperheroItemDto.class))
                .collect(Collectors.toList());
    }
}
