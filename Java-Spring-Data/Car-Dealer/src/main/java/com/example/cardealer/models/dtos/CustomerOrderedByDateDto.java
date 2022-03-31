package com.example.cardealer.models.dtos;

import com.example.cardealer.models.entities.Sale;
import com.google.gson.annotations.Expose;

import java.time.LocalDateTime;
import java.util.Set;

public class CustomerOrderedByDateDto {
    @Expose
    private Long Id;

    @Expose
    private String name;

    @Expose
    private String birthDate;

    @Expose
    private Boolean isYoungDriver;

    @Expose
    private Set<Sale> sales;

    public CustomerOrderedByDateDto() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getYoungDriver() {
        return isYoungDriver;
    }

    public void setYoungDriver(Boolean youngDriver) {
        isYoungDriver = youngDriver;
    }

    public Set<Sale> getSales() {
        return sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }
}
