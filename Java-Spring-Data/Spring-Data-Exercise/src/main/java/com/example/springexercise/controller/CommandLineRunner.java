package com.example.springexercise.controller;

import com.example.springexercise.services.AuthorService;
import com.example.springexercise.services.CategoryService;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {
    private final CategoryService categoryService;
    private final AuthorService authorService;

    public CommandLineRunner(CategoryService categoryService, AuthorService authorService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.categoryService.seedCategories();

        this.authorService.seedAuthors();
    }
}
