package com.example.jsonprocessing.model.dto;

import com.google.gson.annotations.Expose;

import java.util.Set;

public class ProductsSoldDto {

    @Expose
    private Integer count;

    @Expose
    private Set<ProductInfoDto> products;

    public ProductsSoldDto() {
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }


    public Set<ProductInfoDto> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductInfoDto> products) {
        this.products = products;
    }
}
