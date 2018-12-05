package com.minkov.superheroes.web.api;

import com.minkov.superheroes.entities.Superhero;
import com.minkov.superheroes.repositories.SuperheroesRepository;
import com.minkov.superheroes.viewModels.SuperheroViewModel;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.Is.is;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SuperheroesApiControllerTests {
    @Autowired
    private SuperheroesRepository superheroesRepository;

    @Autowired
    private SuperheroesApiController controller;
    private List<Superhero> superheroes;

    @Before
    public void setupTest() {
        superheroes = new ArrayList<>();
        when(superheroesRepository.findAll())
                .thenReturn(superheroes);
    }

    @Test
    public void getAllSuperheroes_whenNoSuperheroesInRepository_shouldReturnEmptyCollection() {
        superheroes.clear();
        var result = controller.getAllSuperheroes();
        assertTrue(result.isEmpty());
    }

    @Test
    public void getAlLSuperheroes_whenSuperheroesInRepository_shouldReturnMappedSuperheroes() {
        Superhero entity = new Superhero(1, "Superhero 1", "Secret identity 1");
        superheroes.add(entity);

        List<SuperheroViewModel> result = controller.getAllSuperheroes();
        assertThat(result.size(), is(1));
        SuperheroViewModel viewModel = result.get(0);
        assertThat(viewModel.getId(), is(entity.getId()));
        assertThat(viewModel.getName(), is(entity.getName()));
        assertThat(viewModel.getSecretIdentity(), is(entity.getSecretIdentity()));
    }
}
