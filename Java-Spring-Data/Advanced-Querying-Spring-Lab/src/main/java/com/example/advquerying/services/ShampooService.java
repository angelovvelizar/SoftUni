package com.example.advquerying.services;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

public interface ShampooService {
    List<String> findAllBySize(Size size);

    List<String> findAllBySizeOrLabelId(Size size, Long labelId);

    List<String> findAllByPriceBiggerThan(BigDecimal price);

    Integer countByPriceLowerThan(BigDecimal price);

    List<String> findAllByIngredientsNames(Collection<String> names);

    List<String> findAllWithIngredientsLessThan(int quantity);
}
