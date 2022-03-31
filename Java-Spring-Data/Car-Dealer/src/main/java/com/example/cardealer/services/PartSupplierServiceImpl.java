package com.example.cardealer.services;

import com.example.cardealer.models.dtos.SupplierSeedDto;
import com.example.cardealer.models.entities.Supplier;
import com.example.cardealer.repositories.PartSupplierRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class PartSupplierServiceImpl implements PartSupplierService {
    private final PartSupplierRepository partSupplierRepository;
    private final ModelMapper modelMapper;

    public PartSupplierServiceImpl(PartSupplierRepository partSupplierRepository, ModelMapper modelMapper) {
        this.partSupplierRepository = partSupplierRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedSuppliers(SupplierSeedDto[] supplierSeedDtos) {
        if(this.partSupplierRepository.count() > 0){
            return;
        }

        Arrays.stream(supplierSeedDtos)
                .map(supplierSeedDto -> this.modelMapper.map(supplierSeedDto, Supplier.class))
                .forEach(this.partSupplierRepository::save);
    }

    @Override
    public Supplier getRandomSupplier() {
        long randomId = ThreadLocalRandom.current().nextLong(1, this.partSupplierRepository.count() + 1);
        return this.partSupplierRepository.findById(randomId).orElse(null);
    }
}
