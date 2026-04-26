package com.ecommerce.api.dto;

import com.ecommerce.api.model.Product;

public record ProductDTOCreate(
        String code,
        String img,
        String username,
        Double price,
        String description
) {
    public ProductDTOCreate(String code, String img, String username, Double price, String description) {
        this.code = code;
        this.img = img;
        this.username = username;
        this.price = price;
        this.description = description;
    }

    public ProductDTOCreate(Product product){
        this(
                product.getCode(),
                product.getImg(),
                product.getUsername(),
                product.getPrice(),
                product.getDescription()
        );
    }
}
