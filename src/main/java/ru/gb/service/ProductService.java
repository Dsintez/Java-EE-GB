package ru.gb.service;

import org.springframework.stereotype.Component;
import ru.gb.beans.ProductRepository;
import ru.gb.entity.Product;

import java.util.List;

@Component
public class ProductService {

    private static ProductService instance;

    public Product createNewProduct(int id, String title, float cost){
        return new Product(id, title, cost);
    }

    public List<Product> getProducts(){
        return ProductRepository.getInstance().getProducts();
    }

    public static ProductService getInstance() {
        return instance;
    }

    static {
        instance = new ProductService();
    }
}
