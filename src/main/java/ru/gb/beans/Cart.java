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

    public void putProduct(int id) {
        productsCarts.add(ProductRepository.getInstance().getProduct(id));
    }

    public void removeProduct(int id) {
        productsCarts.remove(ProductRepository.getInstance().getProduct(id));
    }

    public List<Product> getProductsCarts() {
        return productsCarts;
    }
}
