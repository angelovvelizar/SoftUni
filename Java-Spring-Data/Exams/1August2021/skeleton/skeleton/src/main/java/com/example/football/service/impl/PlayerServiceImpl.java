package com.example.football.service.impl;

import com.example.football.models.dto.PlayerSeedRootDto;
import com.example.football.models.entity.Player;
import com.example.football.repository.PlayerRepository;
import com.example.football.service.PlayerService;
import com.example.football.service.StatService;
import com.example.football.service.TeamService;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

import static com.example.football.constants.GlobalPaths.*;

@Service
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;
    private final TownService townService;
    private final TeamService teamService;
    private final StatService statService;

    public PlayerServiceImpl(PlayerRepository playerRepository, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser, TownService townService, TeamService teamService, StatService statService) {
        this.playerRepository = playerRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.townService = townService;
        this.teamService = teamService;
        this.statService = statService;
    }


    @Override
    public boolean areImported() {
        return this.playerRepository.count() > 0;
    }

    @Override
    public String readPlayersFileContent() throws IOException {
        return Files.readString(Path.of(PLAYERS_FILE_PATH));
    }

    @Override
    public String importPlayers() throws JAXBException, FileNotFoundException {
        PlayerSeedRootDto playerSeedRootDto = this.xmlParser.fromFile(PLAYERS_FILE_PATH, PlayerSeedRootDto.class);
        StringBuilder sb = new StringBuilder();

        playerSeedRootDto.getPlayers().stream()
                .filter(playerSeedDto -> {
                    boolean isValid = this.validationUtil.isValid(playerSeedDto);

                    sb.append(isValid ? String.format("Successfully imported Player %s %s - %s",
                                    playerSeedDto.getFirstName(), playerSeedDto.getLastName(), playerSeedDto.getPosition()) : "Invalid Player")
                            .append(System.lineSeparator());

                    return isValid;
                }).map(playerSeedDto -> {
                    Player player = this.modelMapper.map(playerSeedDto, Player.class);

                    player.setTown(this.townService.findTownByName(playerSeedDto.getTown().getName()));
                    player.setTeam(this.teamService.findTeamByName(playerSeedDto.getTeam().getName()));
                    player.setStat(this.statService.findStatById(playerSeedDto.getStat().getId()));

                    return player;
                }).forEach(this.playerRepository::save);

        return sb.toString();
    }

    @Override
    public String exportBestPlayers() {
        StringBuilder sb = new StringBuilder();

        this.playerRepository.findAllByBirthdate(LocalDate.parse("1995-01-02"), LocalDate.parse("2002-12-31"))
                .forEach(player -> {
                    sb.append(String.format("Player - %s %s\n" +
                            "\tPosition - %s\n" +
                            "\tTeam - %s\n" +
                            "\tStadium - %s\n", player.getFirstName(),player.getLastName(),
                            player.getPosition(),player.getTeam().getName(),player.getTeam().getStadiumName()));
                });

        return sb.toString();
    }
}
