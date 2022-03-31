package com.example.jsonprocessing.service;

import com.example.jsonprocessing.model.dto.*;
import com.example.jsonprocessing.model.entity.User;
import com.example.jsonprocessing.repository.UserRepository;
import com.example.jsonprocessing.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static com.example.jsonprocessing.constants.GLOBAL_PATH.USER_FILE_PATH;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;


    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }


    @Override
    public void seedUsers() throws FileNotFoundException {
        if(userRepository.count() > 0){
            return;
        }

        Arrays.stream(this.gson.fromJson(new FileReader(USER_FILE_PATH), UserSeedDto[].class))
                .filter(validationUtil::isValid)
                .map(userSeedDto -> this.modelMapper.map(userSeedDto, User.class))
                .forEach(this.userRepository::save);

        //This method doesn't seed anything if just one dto is invalid
        /*UserSeedDto[] userSeedDtos = this.gson.fromJson(new FileReader(USER_FILE_PATH), UserSeedDto[].class);
        for (UserSeedDto userSeedDto : userSeedDtos) {
            if (!this.validationUtil.isValid(userSeedDto)) {
                System.out.println("Non valid user");
                return;
            }
        }

        Set<User> users = this.modelMapper.map(userSeedDtos, new TypeToken<Set<User>>() {
        }.getType());
        this.userRepository.saveAll(users);*/
    }

    @Override
    public User findRandomUser() {
        long randomId = ThreadLocalRandom.current().nextLong(1, this.userRepository.count() + 1);

        return this.userRepository.findById(randomId).orElse(null);
    }

    @Override
    public List<UserWithAtLeastOneProductSoldDto> findAllUsersWithAtLeastOneProductSold() {
        return this.userRepository.findUsersWithAtLeastOneProductSold()
                .stream()
                .map(user -> modelMapper.map(user, UserWithAtLeastOneProductSoldDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public List<UserAndProductDto> usersAndProducts() {
        List<User> users = this.userRepository.findAllByProductsSoldNotNullOrderByProductsSoldDescLastName();



        List<UserAndProductDto> userAndProductDtos = users.stream()
                .map(user -> {
                    UserAndProductDto userAndProductDto = this.modelMapper.map(user, UserAndProductDto.class);
                    //userAndProductDto.setUsersCount(users.size());

                    /*ProductsSoldDto productsSoldDto = this.modelMapper.map(userAndProductDto, ProductsSoldDto.class);
                    productsSoldDto.setCount(user.getProductsSold().size());*/

                    return userAndProductDto;

                }).collect(Collectors.toList());

        return userAndProductDtos;
    }
}
