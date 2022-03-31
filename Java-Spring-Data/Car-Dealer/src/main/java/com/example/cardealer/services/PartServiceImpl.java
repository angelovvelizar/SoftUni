package com.example.cardealer.services;

import com.example.cardealer.models.dtos.PartSeedDto;
import com.example.cardealer.models.entities.Part;
import com.example.cardealer.repositories.PartRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class PartServiceImpl implements PartService {
    private final PartRepository partRepository;
    private final ModelMapper modelMapper;
    private final PartSupplierService partSupplierService;

    public PartServiceImpl(PartRepository partRepository, ModelMapper modelMapper, PartSupplierService partSupplierService) {
        this.partRepository = partRepository;
        this.modelMapper = modelMapper;
        this.partSupplierService = partSupplierService;
    }

    @Override
    public void seedParts(PartSeedDto[] partSeedDtos) {
        if(this.partRepository.count() > 0){
            return;
        }


        for (PartSeedDto partSeedDto : partSeedDtos) {
            Part part = this.modelMapper.map(partSeedDto, Part.class);
            part.setSupplier(this.partSupplierService.getRandomSupplier());
            this.partRepository.save(part);
        }


    }

    @Override
    public Set<Part> getRandomParts() {
        Set<Part> randomParts = new HashSet<>();

        int count = ThreadLocalRandom.current().nextInt(3,6);
        long totalPartsCount = this.partRepository.count();

        long randomId;
        for (int i = 0; i < count; i++) {
            randomId = ThreadLocalRandom.current().nextLong(1, totalPartsCount + 1);
            randomParts.add(this.partRepository.findById(randomId).orElse(null));
        }

        return randomParts;
    }
}
