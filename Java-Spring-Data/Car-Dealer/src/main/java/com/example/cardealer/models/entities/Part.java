package com.example.cardealer.models.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "parts")
public class Part extends BaseEntity{

    @Column
    private String name;

    @Column
    private BigDecimal price;

    @Column
    private Integer quantity;

    @ManyToMany(mappedBy = "parts")
    private Set<Car> cars;

    @ManyToOne
    private Supplier supplier;

    public Part() {
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Part part = (Part) o;
        return Objects.equals(name, part.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
