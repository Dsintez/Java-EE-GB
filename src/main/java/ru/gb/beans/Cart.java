package ru.gb.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.gb.entity.Product;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {

    private List<Product> productsCarts = new ArrayList<>();
    private final ProductRepository productRepository;

    public Cart(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void putProduct(int id) {
        productsCarts.add(productRepository.getProduct(id));
    }

    public void removeProduct(int id) {
        productsCarts.remove(productRepository.getProduct(id));
    }

    public List<Product> getProductsCarts() {
        return productsCarts;
    }
}
