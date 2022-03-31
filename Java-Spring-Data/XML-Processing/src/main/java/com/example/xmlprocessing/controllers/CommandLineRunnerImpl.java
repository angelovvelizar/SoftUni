package com.example.xmlprocessing.controllers;

import com.example.xmlprocessing.models.dtos.*;
import com.example.xmlprocessing.models.dtos.seedDtos.CategorySeedRootDto;
import com.example.xmlprocessing.models.dtos.seedDtos.ProductSeedRootDto;
import com.example.xmlprocessing.models.dtos.seedDtos.UserSeedRootDto;
import com.example.xmlprocessing.services.CategoryService;
import com.example.xmlprocessing.services.ProductService;
import com.example.xmlprocessing.services.UserService;
import com.example.xmlprocessing.utils.XmlParser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.math.BigDecimal;

import static com.example.xmlprocessing.constants.GLOBAL_PATH.*;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final XmlParser xmlParser;
    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;

    public CommandLineRunnerImpl(XmlParser xmlParser, CategoryService categoryService, UserService userService, ProductService productService) {
        this.xmlParser = xmlParser;
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {
        //seedData();

        //writeProductsInRangeInFile(BigDecimal.valueOf(500L), BigDecimal.valueOf(1000L));

        usersWithSoldProducts();

    }

    private void usersWithSoldProducts() throws JAXBException {
        UserViewRootDto userViewRootDto = this.userService.findUsersWithAtLeastOneProductSold();
        this.xmlParser.writeToFile(USERS_WITH_PRODUCTS, userViewRootDto);
    }

    private void writeProductsInRangeInFile(BigDecimal lower, BigDecimal upper) throws JAXBException {
         ProductsInRangeRootDto productsInRangeRootDto = this.productService.getProductsInRange(lower, upper);
         this.xmlParser.writeToFile(PRODUCTS_IN_RANGE,productsInRangeRootDto);
    }

    private void seedData() throws JAXBException, FileNotFoundException {
        if(this.categoryService.getEntityCount() == 0) {
            CategorySeedRootDto categorySeedRootDto = xmlParser.fromFile(CATEGORIES_PATH, CategorySeedRootDto.class);
            this.categoryService.seedCategories(categorySeedRootDto.getCategories());
        }

        if(this.userService.getEntityCount() == 0) {
            UserSeedRootDto userSeedRootDto = xmlParser.fromFile(USERS_PATH, UserSeedRootDto.class);
            System.out.println();
            this.userService.seedUsers(userSeedRootDto.getUsers());
        }

        if(this.productService.getEntityCount() == 0){
            ProductSeedRootDto productSeedRootDto= xmlParser.fromFile(PRODUCTS_PATH, ProductSeedRootDto.class);
            this.productService.seedProducts(productSeedRootDto.getProducts());

        }



    }


}
