package com.example.advquerying.controller;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.entities.Size;
import com.example.advquerying.services.IngredientService;
import com.example.advquerying.services.ShampooService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {
    private final ShampooService shampooService;
    private final IngredientService ingredientService;

    public CommandLineRunner(ShampooService shampooService, IngredientService ingredientService) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }


    @Override
    public void run(String... args) throws Exception {
        //printAllShampoosBySizeOrderedById(Size.MEDIUM);

        //printAllShampoosBySizeOrLabelId(Size.MEDIUM,10);

        //printAllShampoosByPriceBiggerThan(new BigDecimal(5));

        //printAllIngredientsStartingWith("M");

        //printIngredientsOrdered(List.of("Lavender", "Herbs", "Apple"));

        //countShampoosByPriceLowerThan(new BigDecimal("8.50"));

        //printShampoosWithIngredientsNamesIn(List.of("Berry", "Mineral-Collagen"));

        //printShampoosWithIngredientsLessThan(2);

        this.ingredientService.deleteAllByName("Nettle");

    }

    private void printShampoosWithIngredientsLessThan(int quantity) {
        this.shampooService.findAllWithIngredientsLessThan(quantity)
                .forEach(System.out::println);
    }

    private void printShampoosWithIngredientsNamesIn(List<String> names) {
        this.shampooService.findAllByIngredientsNames(names)
                .forEach(System.out::println);
    }

    private void countShampoosByPriceLowerThan(BigDecimal price) {
        System.out.println(this.shampooService.countByPriceLowerThan(price));
    }

    private void printIngredientsOrdered(List<String> names) {
        this.ingredientService.findAllIn(names)
                .forEach(System.out::println);
    }

    private void printAllIngredientsStartingWith(String name) {
        this.ingredientService.findAllStartingWith(name)
                .forEach(System.out::println);

    }

    private void printAllShampoosByPriceBiggerThan(BigDecimal price) {
        this.shampooService.findAllByPriceBiggerThan(price)
                .forEach(System.out::println);
    }

    private void printAllShampoosBySizeOrLabelId(Size size, long id) {
        this.shampooService.findAllBySizeOrLabelId(size,id)
                .forEach(System.out::println);
    }

    private void printAllShampoosBySizeOrderedById(Size size) {
        this.shampooService.findAllBySize(size)
                .forEach(System.out::println);
    }


}
