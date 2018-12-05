package com.minkov.superheroes.config;

import com.minkov.superheroes.repositories.SuperheroesRepository;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class RepositoriesTestConfiguration {
    @Bean
    @Primary
    public SuperheroesRepository superheroesRepository() {
        return Mockito.mock(SuperheroesRepository.class);
    }
}
