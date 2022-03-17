package com.example.mappingexercise.services;

import com.example.mappingexercise.models.dto.GameAddDto;
import com.example.mappingexercise.models.dto.GameViewDto;
import com.example.mappingexercise.models.entities.Game;

import java.math.BigDecimal;
import java.util.List;

public interface GameService {
    void addGame(GameAddDto gameAddDto);

    void editGame(long id, BigDecimal price, double size);

    void deleteGame(long id);

    List<GameViewDto> viewAllGames();

    String getGameDetails(String title);
}
