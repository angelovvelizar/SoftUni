package com.example.xmlprocessing.services;


import com.example.xmlprocessing.models.dtos.ProductInRangeInfoDto;
import com.example.xmlprocessing.models.dtos.seedDtos.ProductSeedDto;
import com.example.xmlprocessing.models.dtos.ProductsInRangeRootDto;
import com.example.xmlprocessing.models.entities.Product;
import com.example.xmlprocessing.repositories.ProductRepository;
import com.example.xmlprocessing.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CategoryService categoryService;


    public ProductServiceImpl(ProductRepository productRepository,ValidationUtil validationUtil, ModelMapper modelMapper, UserService userService, CategoryService categoryService) {
        this.productRepository = productRepository;

        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.categoryService = categoryService;
    }



    @Override
    public long getEntityCount() {
        return this.productRepository.count();
    }

    @Override
    public void seedProducts(List<ProductSeedDto> products) {
        products.stream()
                .filter(validationUtil::isValid)
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
    public ProductsInRangeRootDto  getProductsInRange(BigDecimal lower, BigDecimal upper) {
        List<Product> products = this.productRepository.findAllByPriceBetweenAndBuyerIsNull(lower, upper);

        ProductsInRangeRootDto productsInRangeRootDto = new ProductsInRangeRootDto();
        List<ProductInRangeInfoDto> productsInfo = products.stream()
                .map(product -> {
                    ProductInRangeInfoDto productInRangeInfoDto = this.modelMapper.map(product, ProductInRangeInfoDto.class);
                    productInRangeInfoDto.setSellerFullName(product.getSeller().getFirstName() + " " + product.getSeller().getLastName());
                    return productInRangeInfoDto;
                }).collect(Collectors.toList());

        productsInRangeRootDto.setProducts(productsInfo);
        return productsInRangeRootDto;
    }

}
