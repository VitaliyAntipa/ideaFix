package com.ideafix.model.dto;

public class IdeaListDTO {
    private String name;

    public IdeaListDTO(String name) {
        this.name = name;
    }

    public IdeaListDTO() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
