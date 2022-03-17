package com.example.mappingexercise.services;

import com.example.mappingexercise.models.dto.UserLoginDto;
import com.example.mappingexercise.models.dto.UserRegisterDto;
import com.example.mappingexercise.models.entities.User;

public interface UserService {


    void registerUser(UserRegisterDto userRegisterDto);

    void loginUser(UserLoginDto userLoginDto);

    void logout();

    boolean hasLoggedUser();

    boolean isAdministrator();

    void buyGame(String title);

    void getOwnedGames();
}
