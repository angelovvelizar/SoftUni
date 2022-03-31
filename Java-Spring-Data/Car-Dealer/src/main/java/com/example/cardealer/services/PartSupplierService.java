package com.example.cardealer.services;

import com.example.cardealer.models.dtos.SupplierSeedDto;
import com.example.cardealer.models.entities.Supplier;

public interface PartSupplierService {
    void seedSuppliers(SupplierSeedDto[] supplierSeedDtos);

    Supplier getRandomSupplier();
}
