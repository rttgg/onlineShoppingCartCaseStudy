package com.roman.onlineshoppingcartcasestudy.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Slf4j
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDto {

    Long id;
    String name;
    String description;
    double price;
    String imageName;
    int categoryId;
}
