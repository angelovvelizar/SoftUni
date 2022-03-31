package com.example.cardealer.services;

import com.example.cardealer.models.dtos.CarSeedDto;
import com.example.cardealer.models.dtos.CarWithPartsDto;
import com.example.cardealer.models.dtos.CarsFromToyotaDto;
import com.example.cardealer.models.entities.Car;
import com.example.cardealer.repositories.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final ModelMapper modelMapper;
    private final PartService partService;

    public CarServiceImpl(CarRepository carRepository, ModelMapper modelMapper, PartService partService) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
        this.partService = partService;
    }


    @Override
    public void seedCars(CarSeedDto[] carSeedDtos) {
        if(this.carRepository.count() > 0){
            return;
        }

        for (CarSeedDto carSeedDto : carSeedDtos) {
            Car car = this.modelMapper.map(carSeedDto, Car.class);
            car.setParts(this.partService.getRandomParts());
            this.carRepository.save(car);
        }
    }

    @Override
    public List<CarsFromToyotaDto> getCarsFromToyotaOrderedByDistance() {
        List<Car> cars = this.carRepository.findAllByMakeEqualsOrderByModelAscTravelledDistanceDesc("Toyota");

        return cars.stream()
                .map(car -> this.modelMapper.map(car,CarsFromToyotaDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CarWithPartsDto> getCarsWithParts() {
        List<Car> cars = this.carRepository.findAll();

        return cars.stream()
                .map(car -> this.modelMapper.map(car,CarWithPartsDto.class))
                .collect(Collectors.toList());
    }
}
