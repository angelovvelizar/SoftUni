package com.example.mappingexercise.controllers;

import com.example.mappingexercise.models.dto.GameAddDto;
import com.example.mappingexercise.models.dto.UserLoginDto;
import com.example.mappingexercise.models.dto.UserRegisterDto;
import com.example.mappingexercise.services.GameService;
import com.example.mappingexercise.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class Main implements CommandLineRunner {
    private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private final UserService userService;
    private final GameService gameService;

    public Main(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }


    @Override
    public void run(String... args) throws Exception {

        while(true){
            System.out.println("Please enter commands or Exit: ");
            String[] commands = bufferedReader.readLine().split("\\|");

            switch (commands[0]){
                case "RegisterUser":
                    this.userService.registerUser(
                            new UserRegisterDto(commands[1],commands[2],commands[3],commands[4])
                    );
                    break;
                case "LoginUser":
                    this.userService.loginUser(new UserLoginDto(commands[1], commands[2]));
                    break;
                case "Logout":
                    this.userService.logout();
                    break;
                case "AddGame":
                    this.gameService.addGame(new GameAddDto(commands[1],new BigDecimal(commands[2]),Double.parseDouble(commands[3]),
                            commands[4],commands[5],commands[6], LocalDate.parse(commands[7], DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
                    break;
                case "EditGame":
                    BigDecimal price = new BigDecimal(commands[2].split("=")[1]);
                    double size = Double.parseDouble(commands[3].split("=")[1]);
                    this.gameService.editGame(Long.parseLong(commands[1]), price, size);
                    break;
                case "DeleteGame":
                    this.gameService.deleteGame(Long.parseLong(commands[1]));
                    break;
                case "AllGames":
                    this.gameService.viewAllGames()
                            .forEach(g -> System.out.printf("%s %.2f%n", g.getTitle(), g.getPrice()));
                    break;
                case "DetailGame":
                    System.out.println(this.gameService.getGameDetails(commands[1]));
                    break;
                case "BuyGame":
                    this.userService.buyGame(commands[1]);
                    break;
                case "OwnedGames":
                    this.userService.getOwnedGames();
                    break;
                case "Exit":
                    return;
                default:
                    System.out.println("Invalid command");
                    break;
            }

        }

    }
}
