package com.example.advquerying.services;

import com.example.advquerying.entities.Ingredient;

import java.util.Collection;
import java.util.List;

public interface IngredientService {

    List<String> findAllStartingWith(String name);

    List<String> findAllIn(Collection<String> names);

    void deleteAllByName(String name);
}
