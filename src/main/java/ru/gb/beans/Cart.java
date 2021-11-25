package ru.gb.entity;

import ru.gb.beans.ProductRepository;
import ru.gb.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Product> productsCarts = new ArrayList<>();

    public void putProduct(int id) {
        productsCarts.add(ProductRepository.getInstance().getProduct(id));
    }

    public void removeProduct(int id) {
        productsCarts.remove(ProductRepository.getInstance().getProduct(id));
    }

}
