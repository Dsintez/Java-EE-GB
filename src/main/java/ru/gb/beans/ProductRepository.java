package ru.gb.beans;

import org.springframework.stereotype.Component;
import ru.gb.anatations.InjectProducts;
import ru.gb.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductRepository{

    //@InjectProducts //Зацикливается создание
    private List<Product> products = new ArrayList<>();

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

    public void deleteById(int id) {
        products.remove(id);
    }

    public Product save(Product product) {
        products.add(product);
        product.setId(products.size() - 1);
        return Product.builder()
                .id(product.getId())
                .cost(product.getCost())
                .title(product.getTitle())
                .build();
    }

    public Product edit(Product product) {
        return products.set(product.getId(), product);
    }

    public Optional<Product> findById(int id) {
        if (id >= 0 && id < products.size()) {
            return Optional.ofNullable(products.get(id));
        } else {
            return Optional.empty();
        }
    }

    public long count() {
        return products.size();
    }

    public Iterable<Product> findAll() {
        return new ArrayList<>(products);
    }
}
