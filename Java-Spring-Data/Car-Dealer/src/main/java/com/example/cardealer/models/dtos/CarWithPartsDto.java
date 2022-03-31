package com.example.cardealer.models.dtos;

import com.google.gson.annotations.Expose;

import java.util.Set;

public class CarWithPartsDto {

    @Expose
    private String make;

    @Expose
    private String model;

    @Expose
    private Long travelledDistance;

    @Expose
    private Set<PartDto> parts;

    public CarWithPartsDto() {
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

    public Set<PartDto> getParts() {
        return parts;
    }

    public void setParts(Set<PartDto> parts) {
        this.parts = parts;
    }
}
