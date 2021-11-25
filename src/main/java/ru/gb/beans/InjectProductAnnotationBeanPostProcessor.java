package ru.gb.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import ru.gb.anatations.InjectProducts;
import ru.gb.entity.Product;
import ru.gb.service.ProductService;

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
        String[] tmp = environment.getProperty("ProductCasts").split(",");
        costs = new float[tmp.length];
        for (int i = 0; i < tmp.length; i++) {
            costs[i] = Float.parseFloat(tmp[i]);
        }
        tmp = environment.getProperty("ProductID").split(",");
        id = new int[tmp.length];
        for (int i = 0; i < tmp.length; i++) {
            id[i] = Integer.parseInt(tmp[i]);
        }
        words = environment.getProperty("ProductNames").split(",");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //TODO
        for (int i = 0; i < 5; i++) {
            products.add(ProductService.getInstance().createNewProduct(id[i], words[i], costs[i]));
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
