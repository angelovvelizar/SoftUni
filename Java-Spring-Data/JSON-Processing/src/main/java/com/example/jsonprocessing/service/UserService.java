package com.example.jsonprocessing.service;

import com.example.jsonprocessing.model.dto.UserAndProductDto;
import com.example.jsonprocessing.model.dto.UserSeedDto;
import com.example.jsonprocessing.model.dto.UserWithAtLeastOneProductSoldDto;
import com.example.jsonprocessing.model.entity.User;

import java.io.FileNotFoundException;
import java.util.List;

public interface UserService {

    void seedUsers() throws FileNotFoundException;

    User findRandomUser();

    List<UserWithAtLeastOneProductSoldDto> findAllUsersWithAtLeastOneProductSold();

    List<UserAndProductDto> usersAndProducts();
}
