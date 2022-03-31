package com.example.xmlprocessing.services;


import com.example.xmlprocessing.models.dtos.seedDtos.ProductSeedDto;
import com.example.xmlprocessing.models.dtos.ProductsInRangeRootDto;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    long getEntityCount();

    void seedProducts(List<ProductSeedDto> products);

    ProductsInRangeRootDto getProductsInRange(BigDecimal lower, BigDecimal upper);
}
