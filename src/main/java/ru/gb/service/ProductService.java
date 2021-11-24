package ru.gb.service;

import ru.gb.entity.Product;

public class ProductService {

    private int lastID;

    public Product createNewProduct(String title, float cost){
        return new Product(lastID++, title, cost);
    }
}
