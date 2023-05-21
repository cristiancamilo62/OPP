package com.camilo.mall.domain;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private long code;
    private String name;
    private List<Category> categories;

    public Store(long code, String name) {
        this.code = code;
        this.name = name;
        this.categories = new ArrayList<>();

    }

    public long getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Category> getCategories() {
        return categories;
    }
}
