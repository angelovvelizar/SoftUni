package com.example.jsonprocessing.service;

import com.example.jsonprocessing.model.dto.ProductWithoutBuyerDto;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    void seedProducts() throws FileNotFoundException;

    List<ProductWithoutBuyerDto> findAllProductsInRangeWithoutBuyer(BigDecimal lower, BigDecimal upper);
}
