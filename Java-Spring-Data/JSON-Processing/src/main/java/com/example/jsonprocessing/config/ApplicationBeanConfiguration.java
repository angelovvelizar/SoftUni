package com.example.jsonprocessing.config;


import com.example.jsonprocessing.model.dto.ProductWithoutBuyerDto;
import com.example.jsonprocessing.model.entity.Product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileReader;

@Configuration
public class ApplicationBeanConfiguration {


    @Bean
    public Gson gson(){
        return new GsonBuilder()
                .setPrettyPrinting()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
    }

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
