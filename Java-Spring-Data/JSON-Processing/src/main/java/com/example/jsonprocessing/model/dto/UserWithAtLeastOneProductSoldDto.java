package com.example.jsonprocessing.model.dto;

import com.google.gson.annotations.Expose;

import java.util.Set;

public class UserWithAtLeastOneProductSoldDto {
    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    private Set<ProductWithBuyerDto> productsSold;

    public UserWithAtLeastOneProductSoldDto() {
    }

    public Set<ProductWithBuyerDto> getProductsSold() {
        return productsSold;
    }

    public void setProductsSold(Set<ProductWithBuyerDto> productsSold) {
        this.productsSold = productsSold;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
