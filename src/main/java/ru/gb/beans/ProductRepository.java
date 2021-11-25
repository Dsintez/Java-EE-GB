package ru.gb.beans;

import org.springframework.stereotype.Component;
import ru.gb.anatations.InjectProducts;
import ru.gb.entity.Product;

import java.util.List;

@Component
public class ProductRepository{

    private static ProductRepository instance;

    @InjectProducts
    private List<Product> products;

    public Product getProduct(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    private ProductRepository() {
        instance = this;
    }

    public List<Product> getProducts() {
        return products;
    }

    public static ProductRepository getInstance() {
        return instance;
    }
}
