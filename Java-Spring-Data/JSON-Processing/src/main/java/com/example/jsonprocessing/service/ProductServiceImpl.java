package com.example.jsonprocessing.service;

import com.example.jsonprocessing.constants.GLOBAL_PATH;
import com.example.jsonprocessing.model.dto.ProductSeedDto;
import com.example.jsonprocessing.model.dto.ProductWithoutBuyerDto;
import com.example.jsonprocessing.model.entity.Product;
import com.example.jsonprocessing.repository.ProductRepository;
import com.example.jsonprocessing.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.jsonprocessing.constants.GLOBAL_PATH.*;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CategoryService categoryService;


    public ProductServiceImpl(ProductRepository productRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper, UserService userService, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedProducts() throws FileNotFoundException {
        if(this.productRepository.count() > 0){
            return;
        }

        ProductSeedDto[] productSeedDtos = this.gson.fromJson(new FileReader(PRODUCT_FILE_PATH),ProductSeedDto[].class);

        Arrays.stream(productSeedDtos).filter(validationUtil::isValid)
                .map(productSeedDto -> {
                    Product product = this.modelMapper.map(productSeedDto, Product.class);
                    product.setSeller(this.userService.findRandomUser());
                    if(product.getPrice().compareTo(BigDecimal.valueOf(750L)) > 0){
                        product.setBuyer(this.userService.findRandomUser());
                    }
                    product.setCategories(this.categoryService.findRandomCategories());

                    return product;
                }).forEach(this.productRepository::save);
    }

    @Override
    public List<ProductWithoutBuyerDto> findAllProductsInRangeWithoutBuyer(BigDecimal lower, BigDecimal upper) {
        return this.productRepository.findAllByPriceBetweenAndBuyerIsNullOrderByPrice(lower,upper)
                .stream()
                .map(product -> {
                    ProductWithoutBuyerDto productWithoutBuyerDto = this.modelMapper.map(product, ProductWithoutBuyerDto.class);
                    productWithoutBuyerDto.setFullName(String.format("%s %s",
                            product.getSeller().getFirstName(), product.getSeller().getLastName()));

                    return productWithoutBuyerDto;
                })
                .collect(Collectors.toList());
    }
}
