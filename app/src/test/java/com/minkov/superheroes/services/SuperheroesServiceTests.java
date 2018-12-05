package com.minkov.superheroes.services;

import com.minkov.superheroes.entities.Superhero;
import com.minkov.superheroes.repositories.SuperheroesRepository;
import com.minkov.superheroes.services.implementations.SuperheroesServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SuperheroesServiceTests {
    private List<Superhero> superheroes;
    @Mock
    private SuperheroesRepository mockSuperheroesRepository;

    private ModelMapper modelMapper;

    private SuperheroesServiceImpl service;

    @Before
    public void setupTests() {
        superheroes = new ArrayList<>();
        when(mockSuperheroesRepository.findAll())
                .thenReturn(superheroes);
        modelMapper = new ModelMapper();

        service = new SuperheroesServiceImpl(mockSuperheroesRepository, modelMapper);
    }

    @Test
    public void getAll_whenNoSuperheroes_shouldReturnEmptyList() {
        var dts = service.getAll();
        Assert.assertTrue(dts.isEmpty());
    }

    @Test
    public void getAll_whenSuperheroes_shouldReturnMappedElements() {
        var superhero = new Superhero(1, "SH 1", "SI 1");
        superheroes.add(superhero);
        var dts = service.getAll();
        assertEquals(dts.size(), 1);
        var returnedSuperhero = dts.get(0);
        assertEquals(superhero.getId(), returnedSuperhero.getId());
        assertEquals(superhero.getName(), returnedSuperhero.getName());
        assertEquals(superhero.getSecretIdentity(), returnedSuperhero.getSecretIdentity());
    }
}
