package com.example.mappingexercise.services;

import com.example.mappingexercise.models.dto.GameOwnedDto;
import com.example.mappingexercise.models.dto.GameViewDto;
import com.example.mappingexercise.models.dto.UserLoginDto;
import com.example.mappingexercise.models.dto.UserRegisterDto;
import com.example.mappingexercise.models.entities.Game;
import com.example.mappingexercise.models.entities.User;
import com.example.mappingexercise.repositories.GameRepository;
import com.example.mappingexercise.repositories.UserRepository;
import com.example.mappingexercise.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private User loggedUser;
    private final GameRepository gameRepository;
    private static Set<String> gameTitles = new HashSet<>();

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil, GameRepository gameRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gameRepository = gameRepository;
    }


    @Override
    public void registerUser(UserRegisterDto userRegisterDto) {
        if(!userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword())){
            System.out.println("Wrong confirm password");
            return;
        }

        Set<ConstraintViolation<UserRegisterDto>> violations = validationUtil.violation(userRegisterDto);

        if(!violations.isEmpty()){
            violations.stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return;
        }

        User user = this.modelMapper.map(userRegisterDto, User.class);
        userRepository.save(user);
        System.out.println(userRegisterDto.getFullName() + " was registered");


    }

    @Override
    public void loginUser(UserLoginDto userLoginDto) {

        Set<ConstraintViolation<UserLoginDto>> violation = validationUtil.violation(userLoginDto);

        if(!violation.isEmpty()){
            violation.stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return;
        }

        User user = this.userRepository.findUserByEmailAndPassword(userLoginDto.getEmail(),userLoginDto.getPassword())
                .orElse(null);

        if(user == null){
            System.out.println("Incorrect username / password");
            return;
        }


        this.loggedUser = user;
        System.out.println("Successfully logged in " + user.getFullName());
    }

    @Override
    public void logout() {
        if(this.loggedUser == null){
            System.out.println("Cannot log out. No user was logged in.");
            return;
        }

        System.out.println("User " + this.loggedUser.getFullName() + " successfully logged out");
        this.loggedUser = null;
    }

    @Override
    public boolean hasLoggedUser() {
        return this.loggedUser != null;
    }

    @Override
    public boolean isAdministrator() {
        return this.loggedUser.getAdministrator() != null;
    }

    @Override
    public void buyGame(String title) {
        if(this.loggedUser == null){
            System.out.println("You're not logged in.");
            return;
        }

        Game game = this.gameRepository.findGameByTitle(title);
        if(gameTitles.contains(game.getTitle())){
            System.out.println("You already bought this game.");
            return;
        }
        this.loggedUser.setGames(new HashSet<>());
        this.loggedUser.getGames().add(game);
        gameTitles.add(game.getTitle());
        System.out.println("Bought game: " + game.getTitle());
    }

    @Override
    public void getOwnedGames() {
        if(this.loggedUser == null){
            System.out.println("You're not logged in.");
            return;
        }

        Set<GameOwnedDto> ownedGames = this.modelMapper.map(this.loggedUser.getGames(),new TypeToken<Set<GameOwnedDto>>() {}.getType());

        ownedGames.forEach(g -> System.out.println(g.getTitle()));
    }
}
