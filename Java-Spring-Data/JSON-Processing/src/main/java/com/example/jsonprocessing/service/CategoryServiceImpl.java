package com.example.jsonprocessing.service;

import com.example.jsonprocessing.model.dto.CategoryByProductDto;
import com.example.jsonprocessing.model.dto.CategorySeedDto;
import com.example.jsonprocessing.model.entity.Category;
import com.example.jsonprocessing.model.entity.Product;
import com.example.jsonprocessing.repository.CategoryRepository;
import com.example.jsonprocessing.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static com.example.jsonprocessing.constants.GLOBAL_PATH.CATEGORIES_FILE_PATH;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final Gson gson;


    public CategoryServiceImpl(CategoryRepository categoryRepository, ValidationUtil validationUtil, ModelMapper modelMapper, Gson gson) {
        this.categoryRepository = categoryRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }


    @Override
    public void seedCategories() throws FileNotFoundException {
        if(categoryRepository.count() > 0 ){
            return;
        }

        Arrays.stream(this.gson.fromJson(new FileReader(CATEGORIES_FILE_PATH), CategorySeedDto[].class))
                .filter(validationUtil::isValid)
                .map(categorySeedDto -> this.modelMapper.map(categorySeedDto,Category.class))
                .forEach(this.categoryRepository::save);

        //This method doesn't seed anything if just one dto is invalid

        /*CategorySeedDto[] categorySeedDtos = this.gson.fromJson(new FileReader(CATEGORIES_FILE_PATH), CategorySeedDto[].class);
        for (CategorySeedDto categorySeedDto : categorySeedDtos) {
            if(!validationUtil.isValid(categorySeedDto)){
                System.out.println("Non valid category");
                return;
            }
        }

        Set<Category> categories = modelMapper.map(categorySeedDtos, new TypeToken<Set<Category>>() {
        }.getType());
        this.categoryRepository.saveAll(categories);*/
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

    @Override
    public List<CategoryByProductDto> allCategoriesOrderedByNumberOfProducts() {
        List<Category> categories = this.categoryRepository.findAllCategoriesOrderedByNumberOfProducts();

        return categories.stream()
                .map(category -> {
                    CategoryByProductDto categoryByProductDto = this.modelMapper.map(category, CategoryByProductDto.class);

                    categoryByProductDto.setProductsCount(category.getProducts().size());
                    double average = category.getProducts().
                            stream().map(Product::getPrice).
                            map(BigDecimal::doubleValue).
                            mapToDouble(a -> a).
                            average().
                            orElse(0.00);
                    categoryByProductDto.setAveragePrice(BigDecimal.valueOf(average));

                    double totalRevenue = category.getProducts()
                            .stream()
                            .map(Product::getPrice)
                            .map(BigDecimal::doubleValue)
                            .mapToDouble(a -> a)
                            .sum();
                    categoryByProductDto.setTotalRevenue(BigDecimal.valueOf(totalRevenue));

                    return categoryByProductDto;
                }).toList();
    }
}
