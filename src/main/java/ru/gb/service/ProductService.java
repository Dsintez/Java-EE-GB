package ru.gb.service;

import org.springframework.stereotype.Component;
import ru.gb.entity.Product;


@Component
public class ProductService {

    private static ProductService instance;

    public Product createNewProduct(int id, String title, float cost){
        return new Product(id, title, cost);
    }

    public static ProductService getInstance() {
        return instance;
    }

    static {
        instance = new ProductService();
    }
}
