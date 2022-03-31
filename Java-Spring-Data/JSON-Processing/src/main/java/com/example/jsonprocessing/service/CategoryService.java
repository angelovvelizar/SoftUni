package com.example.jsonprocessing.service;

import com.example.jsonprocessing.model.dto.CategoryByProductDto;
import com.example.jsonprocessing.model.dto.CategorySeedDto;
import com.example.jsonprocessing.model.entity.Category;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Set;

public interface CategoryService {
    void seedCategories() throws FileNotFoundException;

    Set<Category> findRandomCategories();

    List<CategoryByProductDto> allCategoriesOrderedByNumberOfProducts();
}
