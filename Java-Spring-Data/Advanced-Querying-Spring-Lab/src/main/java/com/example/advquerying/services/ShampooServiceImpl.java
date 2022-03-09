package com.example.advquerying.services;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import com.example.advquerying.repositories.ShampooRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShampooServiceImpl implements ShampooService {
    private final ShampooRepository shampooRepository;

    public ShampooServiceImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }


    @Override
    public List<String> findAllBySize(Size size) {
        return this.shampooRepository.findAllBySizeOrderById(size)
                .stream()
                .map(shampoo -> String.format("%s %s %.2flv.",
                        shampoo.getBrand(),shampoo.getSize(),shampoo.getPrice()))
                .collect(Collectors.toList());

    }

    @Override
    public List<String> findAllBySizeOrLabelId(Size size, Long labelId) {
        return this.shampooRepository.findAllBySizeOrLabelIdOrderByPrice(size,labelId)
                .stream()
                .map(shampoo -> String.format("%s %s %.2flv.",
                        shampoo.getBrand(),shampoo.getSize(),shampoo.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllByPriceBiggerThan(BigDecimal price) {
        return this.shampooRepository.findAllByPriceGreaterThanOrderByPriceDesc(price)
                .stream()
                .map(shampoo -> String.format("%s %s %.2flv.",
                        shampoo.getBrand(),shampoo.getSize(),shampoo.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public Integer countByPriceLowerThan(BigDecimal price) {
        return this.shampooRepository.countAllByPriceIsLessThan(price);
    }

    @Override
    public List<String> findAllByIngredientsNames(Collection<String> names) {
        return this.shampooRepository.findAllByIngredientsNames(names)
                .stream()
                .map(shampoo -> String.format("%s", shampoo.getBrand()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllWithIngredientsLessThan(int quantity) {
        return this.shampooRepository.findAllWithIngredientsLessThan(quantity)
                .stream()
                .map(Shampoo::getBrand)
                .collect(Collectors.toList());
    }
}
