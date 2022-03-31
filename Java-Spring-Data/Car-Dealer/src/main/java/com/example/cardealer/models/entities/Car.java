package com.example.cardealer.models.entities;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity {

    @Column
    private String make;

    @Column
    private String model;

    @Column(name = "travelled_distance")
    private Long travelledDistance;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Part> parts;

    public Car() {
    }

    public Set<Part> getParts() {
        return parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public Long getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(Long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }
}
