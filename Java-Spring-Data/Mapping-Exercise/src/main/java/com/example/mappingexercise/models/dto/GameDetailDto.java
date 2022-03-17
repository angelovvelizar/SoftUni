package com.example.mappingexercise.models.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GameDetailDto {
    private String title;
    private BigDecimal price;
    private String description;
    private LocalDate localDate;

    public GameDetailDto() {
    }

    public GameDetailDto(String title, BigDecimal price, String description, LocalDate localDate) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.localDate = localDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}
