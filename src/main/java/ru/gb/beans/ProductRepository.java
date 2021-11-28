package ru.gb.beans;

import org.springframework.stereotype.Component;
import ru.gb.anatations.InjectProducts;
import ru.gb.entity.Product;

import java.util.List;

@Component
public class ProductRepository{

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

    public List<Product> getProducts() {
        return products;
    }
}
