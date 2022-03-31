package com.example.cardealer.services;

import com.example.cardealer.models.dtos.LocalSuppliersDto;

import java.util.List;

public interface SupplierService {
    List<LocalSuppliersDto> getLocalSuppliers();
}
