package com.example.cardealer.services;

import com.example.cardealer.models.dtos.CustomerOrderedByDateDto;
import com.example.cardealer.models.dtos.CustomerSeedDto;

import java.util.List;

public interface CustomerService {

    void seedCustomers(CustomerSeedDto[] customerSeedDtos);

    List<CustomerOrderedByDateDto> getCustomersOrderedByDate();
}
