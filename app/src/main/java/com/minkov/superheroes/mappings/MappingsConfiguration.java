package com.minkov.superheroes.mappings;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MappingsConfiguration {
    private static ModelMapper mapper;

    static {
        mapper = new ModelMapper();
        MappingsInitializer.initMappings(mapper);
        mapper.validate();
    }

    @Bean
    public ModelMapper modelMapper() {
        return mapper;
    }


}
