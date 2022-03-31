package com.example.football.service.impl;

import com.example.football.constants.GlobalPaths;
import com.example.football.models.dto.TownSeedDto;
import com.example.football.models.entity.Town;
import com.example.football.repository.TownRepository;
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
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public TownServiceImpl(TownRepository townRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.townRepository = townRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }


    @Override
    public boolean areImported() {
        return this.townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(Path.of(TOWN_FILE_PATH));
    }

    @Override
    public String importTowns() throws FileNotFoundException {
        TownSeedDto[] townSeedDtos = this.gson.fromJson(new FileReader(TOWN_FILE_PATH), TownSeedDto[].class);
        StringBuilder sb = new StringBuilder();
        final int a = 2;

        Arrays.stream(townSeedDtos)
                .filter(townSeedDto -> {
                    boolean isValid = (this.validationUtil.isValid(townSeedDto)) && (this.townRepository.findTownByName(townSeedDto.getName()) == null);

                    sb.append(isValid ? String.format("Successfully imported Town %s - %d",
                                    townSeedDto.getName(), townSeedDto.getPopulation()) : "Invalid town")
                            .append(System.lineSeparator());

                    return isValid;
                }).map(townSeedDto -> this.modelMapper.map(townSeedDto, Town.class))
                .forEach(this.townRepository::save);

        return sb.toString();
    }

    @Override
    public Town findTownByName(String townName) {
        return this.townRepository.findTownByName(townName);
    }
}
