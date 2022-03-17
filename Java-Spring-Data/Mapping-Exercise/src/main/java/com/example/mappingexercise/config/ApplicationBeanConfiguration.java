package com.example.mappingexercise.config;


import com.example.mappingexercise.models.dto.GameAddDto;
import com.example.mappingexercise.models.entities.Game;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class ApplicationBeanConfiguration {


    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.typeMap(GameAddDto.class, Game.class)
                .addMappings(mapper -> mapper.map(GameAddDto::getThumbnailURL,Game::setImageThumbnail));


        Converter<String, LocalDate> localDateConverter =
                mappingContext -> LocalDate.parse(mappingContext.getSource(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        modelMapper.addConverter(localDateConverter);

        return modelMapper;
    }
}
