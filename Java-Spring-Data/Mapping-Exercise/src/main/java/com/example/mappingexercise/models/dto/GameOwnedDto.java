package com.example.mappingexercise.models.dto;

public class GameOwnedDto {
    private String title;

    public GameOwnedDto() {
    }

    public GameOwnedDto(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
