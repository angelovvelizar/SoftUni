package com.example.cardealer.controllers;

import com.example.cardealer.models.dtos.*;
import com.example.cardealer.services.*;
import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.List;

import static com.example.cardealer.constants.GLOBAL_PATHS.*;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final PartSupplierService partSupplierService;
    private final PartService partService;
    private final CarService carService;
    private final CustomerService customerService;
    private final SaleService saleService;
    private final SupplierService supplierService;
    private final Gson gson;
    private final BufferedReader bufferedReader;

    public CommandLineRunnerImpl(PartSupplierService partSupplierService, PartService partService, CarService carService, CustomerService customerService, SaleService saleService, SupplierService supplierService, Gson gson) {
        this.partSupplierService = partSupplierService;
        this.partService = partService;
        this.carService = carService;
        this.customerService = customerService;
        this.saleService = saleService;
        this.supplierService = supplierService;
        this.gson = gson;
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(String... args) throws Exception {
        //seedData();

        getCustomersOrdered();

        getAllCarsFromToyota();

        getLocalSuppliers();

        getCarsWithTheirParts();


    }

    private void getCarsWithTheirParts() {
        List<CarWithPartsDto> carWithPartsDtos = this.carService.getCarsWithParts();
        writeInFile(carWithPartsDtos,CARS_WITH_PARTS);
    }

    private void getLocalSuppliers() {
        List<LocalSuppliersDto> localSuppliersDtos = this.supplierService.getLocalSuppliers();
        writeInFile(localSuppliersDtos, LOCAL_SUPPLIERS);
    }

    private void getAllCarsFromToyota() {
        List<CarsFromToyotaDto> carsFromToyotaDtos = this.carService.getCarsFromToyotaOrderedByDistance();
        writeInFile(carsFromToyotaDtos, CARS_MADE_FROM_TOYOTA);
    }

    private void getCustomersOrdered() {
        List<CustomerOrderedByDateDto> customerOrderedByDateDtos = this.customerService.getCustomersOrderedByDate();
        writeInFile(customerOrderedByDateDtos,CUSTOMER_ORDERED_BY_DATE_JSON);
    }

    private void seedData() throws FileNotFoundException {
        seedSuppliers();
        seedParts();
        seedCars();
        seedCustomers();
        seedSales();
    }

    private <T> void writeInFile(List<T> dtoList, String path) {
        try(FileWriter fw = new FileWriter(path)) {
            this.gson.toJson(dtoList, fw);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void seedSales() {
        this.saleService.seedSales();
    }

    private void seedCustomers() throws FileNotFoundException {
        CustomerSeedDto[] customerSeedDtos = this.gson.fromJson(new FileReader(CUSTOMER_PATH), CustomerSeedDto[].class);
        this.customerService.seedCustomers(customerSeedDtos);
    }

    private void seedCars() throws FileNotFoundException {
        CarSeedDto[] carSeedDtos = this.gson.fromJson(new FileReader(CARS_PATH), CarSeedDto[].class);
        this.carService.seedCars(carSeedDtos);
    }

    private void seedParts() throws FileNotFoundException {
        PartSeedDto[] partSeedDtos = this.gson.fromJson(new FileReader(PARTS_PATH), PartSeedDto[].class);
        this.partService.seedParts(partSeedDtos);
    }

    private void seedSuppliers() throws FileNotFoundException {
        SupplierSeedDto[] supplierSeedDtos = this.gson.fromJson(new FileReader(SUPPLIERS_PATH), SupplierSeedDto[].class);
        this.partSupplierService.seedSuppliers(supplierSeedDtos);
    }
}
