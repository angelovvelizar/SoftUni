package com.example.cardealer.services;

import com.example.cardealer.models.dtos.LocalSuppliersDto;
import com.example.cardealer.models.entities.Supplier;
import com.example.cardealer.repositories.SupplierRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;
    private final ModelMapper modelMapper;

    public SupplierServiceImpl(SupplierRepository supplierRepository, ModelMapper modelMapper) {
        this.supplierRepository = supplierRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<LocalSuppliersDto> getLocalSuppliers() {
        List<Supplier> suppliers = this.supplierRepository.findAllByIsImporterFalse();

        return suppliers.stream()
                .map(supplier -> {
                    LocalSuppliersDto localSupplier = this.modelMapper.map(supplier, LocalSuppliersDto.class);
                    localSupplier.setPartsCount(supplier.getParts().size());
                    return localSupplier;
                }).collect(Collectors.toList());
    }
}
