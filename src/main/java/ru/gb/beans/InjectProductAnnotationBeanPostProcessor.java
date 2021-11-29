package ru.gb.beans;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import ru.gb.anatations.InjectProducts;
import ru.gb.entity.Product;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Component
public class InjectProductAnnotationBeanPostProcessor implements BeanPostProcessor {

    List<Product> products = new ArrayList<>();
    private String words[];
    private float costs[];
    private int id[];

    @Autowired
    private Environment environment;

    @PostConstruct
    public void init() {
        words = environment.getProperty("ProductNames").split(",");
        String[] costs = environment.getProperty("ProductCosts").split(",");
        String[] ids = environment.getProperty("ProductID").split(",");
        this.costs = new float[costs.length];
        this.id = new int[ids.length];
        for (int i = 0; i < costs.length; i++) {
            this.costs[i] = Float.parseFloat(costs[i]);
            this.id[i] = Integer.parseInt(ids[i]);
        }
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        for (int i = 0; i < words.length; i++) {
            products.add(new Product(id[i], words[i], costs[i]));
        }
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            InjectProducts annotation = field.getAnnotation(InjectProducts.class);
            if (annotation != null) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, products);
            }
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }
}
