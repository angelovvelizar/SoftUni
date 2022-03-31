package com.example.cardealer.services;

import com.example.cardealer.models.dtos.PartSeedDto;
import com.example.cardealer.models.entities.Part;

import java.util.Set;

public interface PartService {
    void seedParts(PartSeedDto[] partSeedDtos);

    Set<Part> getRandomParts();
}
