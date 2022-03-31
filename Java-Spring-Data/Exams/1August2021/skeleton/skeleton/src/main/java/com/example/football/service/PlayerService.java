package com.example.football.service;

import org.springframework.stereotype.Repository;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;


public interface PlayerService {
    boolean areImported();

    String readPlayersFileContent() throws IOException;

    String importPlayers() throws JAXBException, FileNotFoundException;

    String exportBestPlayers();
}
