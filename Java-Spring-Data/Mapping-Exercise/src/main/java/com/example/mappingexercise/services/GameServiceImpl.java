package com.example.mappingexercise.services;

import com.example.mappingexercise.models.dto.GameAddDto;
import com.example.mappingexercise.models.dto.GameDetailDto;
import com.example.mappingexercise.models.dto.GameViewDto;
import com.example.mappingexercise.models.entities.Game;
import com.example.mappingexercise.repositories.GameRepository;
import com.example.mappingexercise.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final UserService userService;
    private final ModelMapper mapper;
    private final ValidationUtil validationUtil;
    private static final String LOG_IN_ERROR = "Please log in first.";
    private static final String INVALID_GAME_ID = "Invalid game id";
    private static final String UNAUTHORIZED_ERROR = "You don't have administrator rights";

    public GameServiceImpl(GameRepository gameRepository, UserService userService, ModelMapper mapper, ValidationUtil validationUtil) {
        this.gameRepository = gameRepository;
        this.userService = userService;
        this.mapper = mapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void addGame(GameAddDto gameAddDto) {
        if (!userService.hasLoggedUser()) {
            System.out.println(LOG_IN_ERROR);
            return;
        }

        if(!isAdministrator()){
            System.out.println(UNAUTHORIZED_ERROR);
            return;
        }

        Set<ConstraintViolation<GameAddDto>> violations = validationUtil.violation(gameAddDto);

        if (!violations.isEmpty()) {
            violations.stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return;
        }

        Game game = mapper.map(gameAddDto, Game.class);

        this.gameRepository.save(game);
        System.out.println("Added " + gameAddDto.getTitle());

    }

    @Override
    public void editGame(long id, BigDecimal price, double size) {
        if (!userService.hasLoggedUser()) {
            System.out.println(LOG_IN_ERROR);
            return;
        }

        if(!isAdministrator()){
            System.out.println(UNAUTHORIZED_ERROR);
            return;
        }

        Game game = this.gameRepository.findById(id).orElse(null);

        if (game == null) {
            System.out.println(INVALID_GAME_ID);
            return;
        }

        game.setPrice(price);
        game.setSize(size);

        this.gameRepository.save(game);
        System.out.println("Edited " + game.getTitle());
    }

    @Override
    public void deleteGame(long id) {
        if (!userService.hasLoggedUser()) {
            System.out.println(LOG_IN_ERROR);
            return;
        }

        if(!isAdministrator()){
            System.out.println(UNAUTHORIZED_ERROR);
            return;
        }

        Game game = this.gameRepository.findById(id).orElse(null);
        if (game == null) {
            System.out.println(INVALID_GAME_ID);
            return;
        }

        this.gameRepository.delete(game);
        System.out.println("Deleted " + game.getTitle());
    }

    @Override
    public List<GameViewDto> viewAllGames() {
        List<Game> games = this.gameRepository.findAll();

        return this.mapper.map(games,new TypeToken<List<GameViewDto>>() {}.getType());
    }

    @Override
    public String getGameDetails(String title) {
        Game game = this.gameRepository.findGameByTitle(title);
        GameDetailDto gameDetailDto = this.mapper.map(game, GameDetailDto.class);

        return String.format("Title: %s%n" +
                "Price: %.2f%n" +
                "Description: %s%n" +
                "Release Date: %s",gameDetailDto.getTitle(),gameDetailDto.getPrice(),gameDetailDto.getDescription(),gameDetailDto.getLocalDate());
    }

    private boolean isAdministrator(){
        return this.userService.isAdministrator();
    }


}
