package com.example.xmlprocessing.services;


import com.example.xmlprocessing.models.dtos.seedDtos.CategorySeedDto;
import com.example.xmlprocessing.models.entities.Category;
import com.example.xmlprocessing.repositories.CategoryRepository;
import com.example.xmlprocessing.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;




    public CategoryServiceImpl(CategoryRepository categoryRepository, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }


    @Override
    public void seedCategories(List<CategorySeedDto> categories) {
        categories.stream()
                .filter(validationUtil::isValid)
                .map(categorySeedDto -> this.modelMapper.map(categorySeedDto,Category.class))
                .forEach(this.categoryRepository::save);

    }

    @Override
    public long getEntityCount() {
        return this.categoryRepository.count();
    }

    @Override
    public Set<Category> findRandomCategories() {

        Set<Category> categories = new HashSet<>();
        int catCount = ThreadLocalRandom.current().nextInt(1,3);
        long totalCategoriesCount = this.categoryRepository.count();

       // Set<Long> alreadyAddedCategories = new HashSet<>();
        for (int i = 0; i < catCount; i++) {
            long randomId = ThreadLocalRandom.current().nextLong(1, totalCategoriesCount + 1);

           // if(!alreadyAddedCategories.contains(randomId)){
                Category category = this.categoryRepository.findById(randomId).orElse(null);
                categories.add(category);
           // }

            //alreadyAddedCategories.add(randomId);
        }

        return categories;
    }

}
