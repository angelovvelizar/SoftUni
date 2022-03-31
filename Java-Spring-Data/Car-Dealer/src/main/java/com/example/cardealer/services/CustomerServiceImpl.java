package com.example.cardealer.services;

import com.example.cardealer.models.dtos.CustomerOrderedByDateDto;
import com.example.cardealer.models.dtos.CustomerSeedDto;
import com.example.cardealer.models.entities.Customer;
import com.example.cardealer.repositories.CustomerRepository;
import org.modelmapper.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;


    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void seedCustomers(CustomerSeedDto[] customerSeedDtos) {
        if(this.customerRepository.count() > 0 ){
            return;
        }

        for (CustomerSeedDto customerSeedDto : customerSeedDtos) {
            Customer customer = this.modelMapper.map(customerSeedDto, Customer.class);
            String birthDate = customerSeedDto.getBirthDate();
            customer.setBirthDate(LocalDateTime.parse(birthDate,ISO_LOCAL_DATE_TIME));
            this.customerRepository.save(customer);
        }


    }

    @Override
    public List<CustomerOrderedByDateDto> getCustomersOrderedByDate() {
        List<Customer> customers = this.customerRepository.findAllByIdExistsOrderByBirthDateAscIsYoungDriver();

        return customers.stream()
                .map(customer -> {
                    CustomerOrderedByDateDto customerOrderedByDateDto = this.modelMapper.map(customer, CustomerOrderedByDateDto.class);
                    customerOrderedByDateDto.setBirthDate(customer.getBirthDate().toString());

                    return customerOrderedByDateDto;
                })
                .collect(Collectors.toList());
    }
}
