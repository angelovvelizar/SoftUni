package com.example.xmlprocessing.services;


import com.example.xmlprocessing.models.dtos.UserViewRootDto;
import com.example.xmlprocessing.models.dtos.UserWithProductDto;
import com.example.xmlprocessing.models.dtos.seedDtos.UserSeedDto;
import com.example.xmlprocessing.models.entities.User;
import com.example.xmlprocessing.repositories.UserRepository;
import com.example.xmlprocessing.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }


    @Override
    public void seedUsers(List<UserSeedDto> users) {
        users.stream()
                .filter(validationUtil::isValid)
                .map(userSeedDto -> this.modelMapper.map(userSeedDto,User.class))
                .forEach(this.userRepository::save);
    }

    @Override
    public long getEntityCount() {
        return this.userRepository.count();
    }

    @Override
    public UserViewRootDto findUsersWithAtLeastOneProductSold() {
        UserViewRootDto userViewRootDto = new UserViewRootDto();
        List<UserWithProductDto> userWithProductDtos = this.userRepository.findAllUsersWithAtLeastOneSoldProduct()
                .stream()
                .map(user -> this.modelMapper.map(user, UserWithProductDto.class))
                .collect(Collectors.toList());

        userViewRootDto.setProducts(userWithProductDtos);
        return userViewRootDto;
    }

    @Override
    public User findRandomUser() {
        long randomId = ThreadLocalRandom.current().nextLong(1, this.userRepository.count() + 1);

        return this.userRepository.findById(randomId).orElse(null);
    }

}
