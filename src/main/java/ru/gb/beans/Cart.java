package ru.gb.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.gb.entity.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@Component
@Scope("prototype")
public class Cart implements Consumer<Product> {
    private Map<Integer, List<Product>> productsCarts = new HashMap<>();

    public Cart() {

    }

    public void add(Product product) {
        if (productsCarts.get(product.getId()) == null) {
            List<Product> list = new ArrayList<>();
            list.add(product);
            productsCarts.put(product.getId(), list);
        } else {
            productsCarts.get(product.getId()).add(product);
        }
    }

    public void deleteByProductId(Integer id) {
        if (productsCarts.get(id) != null) {
            productsCarts.get(id).remove(id);
        }
    }

    public void showProductList() {
        System.out.println(productsCarts);
    }

    @Override
    public void accept(Product product) {
        add(product);
    }
}
