package ru.gb.entity;

import lombok.Getter;
import lombok.Setter;

public class Product {

    @Getter
    private final int id;
    @Getter @Setter
    private String title;
    @Getter @Setter
    private float cost;

    public Product(int id, String title, float cost){
        this.id = id;
        this.title = title;
        this.cost = cost;
    }
}
