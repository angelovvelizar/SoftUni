package com.example.xmlprocessing.configs;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileReader;

@Configuration
public class ApplicationBeanConfiguration {



    @Bean
     public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();

        /*modelMapper.typeMap(Product.class, ProductWithoutBuyerDto.class)
                .addMappings(mapper ->
                        mapper.map(product -> product.getSeller().getFirstName() + product.getSeller().getLastName(),
                                ProductWithoutBuyerDto::setFullName));*/
        return modelMapper;
    }
}
