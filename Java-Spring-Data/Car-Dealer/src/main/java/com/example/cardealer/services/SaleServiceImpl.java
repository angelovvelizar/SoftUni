package com.example.cardealer.services;

import com.example.cardealer.repositories.SaleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class SaleServiceImpl implements SaleService {
    private final SaleRepository saleRepository;
    private final ModelMapper modelMapper;

    public SaleServiceImpl(SaleRepository saleRepository, ModelMapper modelMapper) {
        this.saleRepository = saleRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void seedSales() {

    }
}
