package com.example.jsonprocessing.model.dto;

import com.google.gson.annotations.Expose;

import java.util.Set;

public class UserInfoDto {

    @Expose
    private String sellerFirstName;

    @Expose
    private String sellerLastName;

    @Expose
    private Integer sellerAge;

    @Expose
    private Set<ProductsSoldDto> productsSold;

    public UserInfoDto() {
    }

    public String getSellerFirstName() {
        return sellerFirstName;
    }

    public void setSellerFirstName(String sellerFirstName) {
        this.sellerFirstName = sellerFirstName;
    }

    public String getSellerLastName() {
        return sellerLastName;
    }

    public void setSellerLastName(String sellerLastName) {
        this.sellerLastName = sellerLastName;
    }

    public Integer getSellerAge() {
        return sellerAge;
    }

    public void setSellerAge(Integer sellerAge) {
        this.sellerAge = sellerAge;
    }

    public Set<ProductsSoldDto> getProductsSold() {
        return productsSold;
    }

    public void setProductsSold(Set<ProductsSoldDto> productsSold) {
        this.productsSold = productsSold;
    }
}
