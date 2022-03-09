package com.example.advquerying.services;

import com.example.advquerying.repositories.IngredientRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<String> findAllStartingWith(String name) {
        return this.ingredientRepository.findAllByNameStartsWith(name)
                .stream()
                .map(ingredient -> String.format("%s", ingredient.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllIn(Collection<String> names) {
        return this.ingredientRepository.findAllByNameInOrderByPrice(names)
                .stream()
                .map(ingredient -> String.format("%s", ingredient.getName()))
                .collect(Collectors.toList());

    }

    @Override
    @Transactional
    public void deleteAllByName(String name) {
        this.ingredientRepository.deleteAllByName(name);
    }
}
