package ru.gb.beans;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("ru.gb")
@PropertySource("classpath:application.properties")
public class CartConfig {
}
