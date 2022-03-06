package com.example.springexercise.services;

import com.example.springexercise.models.entities.Category;
import com.example.springexercise.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;


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

    @Override
    public Set<Category> getRandomCategories() {
        Set<Category> categories = new HashSet<>();
        int numberOfCategories = ThreadLocalRandom.current().nextInt(1, 4);

        Set<Long> alreadyAddedCategories = new HashSet<>();
        long categoryCount = categoryRepository.count();
        for (int i = 0; i < numberOfCategories; i++) {
            long randomId = ThreadLocalRandom.current().nextLong(1, categoryCount + 1);

            if(!alreadyAddedCategories.contains(randomId)) {
                Category category = categoryRepository.findById(randomId).orElse(null);
                categories.add(category);
            }

            alreadyAddedCategories.add(randomId);
        }

        return categories;
    }
}
