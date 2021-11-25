package ru.gb.service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.beans.Cart;
import ru.gb.beans.CartConfig;
import ru.gb.entity.Product;

import java.util.Arrays;

public class ChangeCart {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CartConfig.class);
        System.out.println(Arrays.asList(context.getBeanDefinitionNames()));
        Cart cart = context.getBean(Cart.class);
        cart.putProduct(3);
        cart.putProduct(5);
        cart.putProduct(4);
        for (Product product : cart.getProductsCarts()) {
            System.out.println(product);
        }
        Cart cart2 = context.getBean(Cart.class);
        for (Product product : cart2.getProductsCarts()) {
            System.out.println(product);
        }
        context.close();
    }
}
