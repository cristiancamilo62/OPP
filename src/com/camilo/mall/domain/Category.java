package com.camilo.mall.domain;

public class Category {
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public Category(){
        this.name = "clothing";
    }

    public String getName() {
        return name;
    }
}

