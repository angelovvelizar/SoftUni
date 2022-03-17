package com.example.mappingexercise.repositories;

import com.example.mappingexercise.models.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    Game findGameByTitle(String title);
}
