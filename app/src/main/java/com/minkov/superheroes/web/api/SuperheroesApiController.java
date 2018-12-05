package com.minkov.superheroes.web.api;

import com.minkov.superheroes.services.SuperheroesService;
import com.minkov.superheroes.viewModels.SuperheroViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SuperheroesApiController {
    private final SuperheroesService superheroesService;
    private final ModelMapper modelMapper;

    public SuperheroesApiController(
            SuperheroesService superheroesService,
            ModelMapper modelMapper
    ) {
        this.superheroesService = superheroesService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/api/superheroes")
    public List<SuperheroViewModel> getAllSuperheroes() {
        var dtos = this.superheroesService.getAll();

        return dtos.stream()
                .map(dto -> modelMapper.map(dto, SuperheroViewModel.class))
                .collect(Collectors.toList());
    }
}
