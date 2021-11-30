package ru.gb.entity;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {

    private Integer id;
    private String title;
    private Float cost;
}
