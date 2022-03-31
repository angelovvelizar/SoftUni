package com.example.xmlprocessing.services;



import com.example.xmlprocessing.models.dtos.UserViewRootDto;
import com.example.xmlprocessing.models.dtos.seedDtos.UserSeedDto;
import com.example.xmlprocessing.models.entities.User;

import java.util.List;

public interface UserService {



    User findRandomUser();

    void seedUsers(List<UserSeedDto> users);

    long getEntityCount();

    UserViewRootDto findUsersWithAtLeastOneProductSold();
}
