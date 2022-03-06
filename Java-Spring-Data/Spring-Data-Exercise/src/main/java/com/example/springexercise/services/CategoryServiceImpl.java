package com.example.springexercise.services;

import com.example.springexercise.models.entities.Category;
import com.example.springexercise.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


@Service
public class CategoryServiceImpl implements CategoryService {
    private static final String CATEGORIES_PATH = "src/main/resources/categories.txt";

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedCategories() throws IOException {
        if(categoryRepository.count() > 0){
            return;
        }

        Files.readAllLines(Path.of(CATEGORIES_PATH))
                .stream().filter(row -> !row.isBlank())
                .forEach(categoryName -> {
                    Category category = new Category(categoryName);
                    categoryRepository.save(category);
                });

    }
}
