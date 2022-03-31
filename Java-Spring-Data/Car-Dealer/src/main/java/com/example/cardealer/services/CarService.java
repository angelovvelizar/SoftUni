package com.example.cardealer.services;

import com.example.cardealer.models.dtos.CarSeedDto;
import com.example.cardealer.models.dtos.CarWithPartsDto;
import com.example.cardealer.models.dtos.CarsFromToyotaDto;

import java.util.List;

public interface CarService {
    void seedCars(CarSeedDto[] carSeedDtos);

    List<CarsFromToyotaDto> getCarsFromToyotaOrderedByDistance();

    List<CarWithPartsDto> getCarsWithParts();
}
