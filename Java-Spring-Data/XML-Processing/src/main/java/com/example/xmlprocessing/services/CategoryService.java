package com.example.xmlprocessing.services;



import com.example.xmlprocessing.models.dtos.seedDtos.CategorySeedDto;
import com.example.xmlprocessing.models.entities.Category;

import java.util.List;
import java.util.Set;

public interface CategoryService {


    Set<Category> findRandomCategories();


    void seedCategories(List<CategorySeedDto> categories);

    long getEntityCount();
}
