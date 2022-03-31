package com.example.football.service.impl;

import com.example.football.models.dto.TeamSeedDto;
import com.example.football.models.entity.Team;
import com.example.football.repository.TeamRepository;
import com.example.football.service.TeamService;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static com.example.football.constants.GlobalPaths.*;

@Service
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final TownService townService;

    public TeamServiceImpl(TeamRepository teamRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil, TownService townService) {
        this.teamRepository = teamRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.townService = townService;
    }


    @Override
    public boolean areImported() {
        return this.teamRepository.count() > 0;
    }

    @Override
    public String readTeamsFileContent() throws IOException {
        return Files.readString(Path.of(TEAMS_FILE_PATH));
    }

    @Override
    public String importTeams() throws FileNotFoundException {
        TeamSeedDto[] teamSeedDtos = this.gson.fromJson(new FileReader(TEAMS_FILE_PATH), TeamSeedDto[].class);
        StringBuilder sb = new StringBuilder();

        Arrays.stream(teamSeedDtos)
                .filter(teamSeedDto -> {
                    boolean isValid = this.validationUtil.isValid(teamSeedDto);

                    sb.append(isValid ? String.format("Successfully imported Team %s - %d"
                            , teamSeedDto.getName(), teamSeedDto.getFanBase()) : "Invalid Team").append(System.lineSeparator());

                    return isValid;
                }).map(teamSeedDto -> {
                    Team team = this.modelMapper.map(teamSeedDto, Team.class);
                    team.setTown(this.townService.findTownByName(teamSeedDto.getTownName()));
                    return team;
                }).forEach(this.teamRepository::save);


        return sb.toString();
    }

    @Override
    public Team findTeamByName(String name) {
        return this.teamRepository.findTeamByName(name);
    }
}
