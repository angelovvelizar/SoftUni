package com.example.cardealer.models.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer extends BaseEntity{

    @Column
    private String name;

    @Column(name = "birth_date")
    private LocalDateTime birthDate;

    @Column(name = "is_young_driver")
    private Boolean isYoungDriver; //less than 2 years of experience --> 5% off for the sale

    @OneToMany(mappedBy = "customer",fetch = FetchType.EAGER)
    private Set<Sale> sales;

    public Set<Sale> getSales() {
        return sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getYoungDriver() {
        return isYoungDriver;
    }

    public void setYoungDriver(Boolean youngDriver) {
        isYoungDriver = youngDriver;
    }
}
