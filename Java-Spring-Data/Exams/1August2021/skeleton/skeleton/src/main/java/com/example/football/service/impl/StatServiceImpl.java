package com.example.football.service.impl;

import com.example.football.constants.GlobalPaths;
import com.example.football.models.dto.StatSeedRootDto;
import com.example.football.models.entity.Stat;
import com.example.football.repository.StatRepository;
import com.example.football.service.StatService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.example.football.constants.GlobalPaths.*;

@Service
public class StatServiceImpl implements StatService {
    private final StatRepository statRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;

    public StatServiceImpl(StatRepository statRepository, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser) {
        this.statRepository = statRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
    }


    @Override
    public boolean areImported() {
        return this.statRepository.count() > 0;
    }

    @Override
    public String readStatsFileContent() throws IOException {
        return Files.readString(Path.of(STATS_FILE_PATH));
    }

    @Override
    public String importStats() throws JAXBException, FileNotFoundException {
        StatSeedRootDto statSeedRootDto = this.xmlParser.fromFile(STATS_FILE_PATH, StatSeedRootDto.class);
        StringBuilder sb = new StringBuilder();

        statSeedRootDto.getStats().stream()
                .filter(statSeedDto -> {
                    boolean isValid = this.validationUtil.isValid(statSeedDto);

                    sb.append(isValid ? String.format("Successfully imported Stat %.2f - %.2f - %.2f",
                            statSeedDto.getPassing(),statSeedDto.getShooting(),statSeedDto.getEndurance()) : "Invalid Stat")
                            .append(System.lineSeparator());

                    return isValid;
                }).map(statSeedDto -> this.modelMapper.map(statSeedDto, Stat.class))
                .forEach(this.statRepository::save);


        return sb.toString();
    }

    @Override
    public Stat findStatById(Long id) {
        return this.statRepository.findById(id).orElse(null);
    }
}
