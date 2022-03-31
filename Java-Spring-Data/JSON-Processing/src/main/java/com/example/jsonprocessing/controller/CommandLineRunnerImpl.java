package com.example.jsonprocessing.controller;

import com.example.jsonprocessing.constants.GLOBAL_PATH;
import com.example.jsonprocessing.model.dto.CategoryByProductDto;
import com.example.jsonprocessing.model.dto.ProductWithoutBuyerDto;
import com.example.jsonprocessing.model.dto.UserAndProductDto;
import com.example.jsonprocessing.model.dto.UserWithAtLeastOneProductSoldDto;
import com.example.jsonprocessing.service.CategoryService;
import com.example.jsonprocessing.service.ProductService;
import com.example.jsonprocessing.service.UserService;
import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.*;
import java.math.BigDecimal;
import java.util.List;

import static com.example.jsonprocessing.constants.GLOBAL_PATH.*;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final UserService userService;
    private final CategoryService categoryService;
    private final ProductService productService;
    private final Gson gson;
    private final BufferedReader bufferedReader;



    public CommandLineRunnerImpl(UserService userService, CategoryService categoryService, ProductService productService, Gson gson) {
        this.userService = userService;
        this.categoryService = categoryService;
        this.productService = productService;
        this.gson = gson;
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }


    @Override
    public void run(String... args) throws Exception {
        seedData();

        while(true){
            System.out.println("Please enter query number or type 'Exit' to exit the program: ");

            String queryNumber = bufferedReader.readLine();
            switch (queryNumber){
                case "1":
                    productsInRangeWithoutBuyer();
                    break;
                case "2":
                    soldProducts();
                    break;
                case "3":
                    categoriesByProducts();
                    break;
                case "4":
                    usersAndProducts();
                    break;
                case "Exit":
                    return;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }

    }

    private void usersAndProducts() throws IOException {
        List<UserAndProductDto> userAndProductDtos =
                this.userService.usersAndProducts();

        FileWriter fileWriter = new FileWriter(USERS_AND_PRODUCTS);
        this.gson.toJson(userAndProductDtos,fileWriter);
        fileWriter.flush();
    }

    private void categoriesByProducts() throws IOException {
        List<CategoryByProductDto> categoryByProductDtos =
                this.categoryService.allCategoriesOrderedByNumberOfProducts();

        FileWriter fileWriter = new FileWriter(CATEGORIES_BY_PRODUCTS_PATH);
        this.gson.toJson(categoryByProductDtos,fileWriter);
        fileWriter.flush();
    }

    private void soldProducts() throws IOException {
        List<UserWithAtLeastOneProductSoldDto> userWithAtLeastOneProductSoldDtos =
                 this.userService.findAllUsersWithAtLeastOneProductSold();

        FileWriter fileWriter = new FileWriter(USER_SOLD_PRODUCTS_PATH);
        this.gson.toJson(userWithAtLeastOneProductSoldDtos, fileWriter);
        fileWriter.flush();
    }

    private void productsInRangeWithoutBuyer() throws IOException {
        List<ProductWithoutBuyerDto> productWithoutBuyerDtos = this.productService
                .findAllProductsInRangeWithoutBuyer(BigDecimal.valueOf(500L),BigDecimal.valueOf(1000L));

        FileWriter fileWriter = new FileWriter(PRODUCTS_IN_RANGE_PATH);
        this.gson.toJson(productWithoutBuyerDtos,fileWriter);
        fileWriter.flush();
    }

    private void seedData() throws FileNotFoundException {
        seedUsers();
        seedCategories();
        seedProducts();
    }

    private void seedProducts() throws FileNotFoundException {
        this.productService.seedProducts();
    }

    private void seedCategories() throws FileNotFoundException {
        this.categoryService.seedCategories();

    }

    private void seedUsers() throws FileNotFoundException {

        this.userService.seedUsers();
    }
}
