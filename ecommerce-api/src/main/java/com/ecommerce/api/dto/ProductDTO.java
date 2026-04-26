package com.ecommerce.api.dto;

import com.ecommerce.api.model.Product;

public record ProductDTO(
        Long id,
        String code,
        String img,
        String username,
        Double price,
        String description
) {
    public ProductDTO(Long id, String code, String img, String username, Double price, String description) {
        this.id = id;
        this.code = code;
        this.img = img;
        this.username = username;
        this.price = price;
        this.description = description;
    }

    public ProductDTO(Product product){
        this(
                product.getId(),
                product.getCode(),
                product.getImg(),
                product.getUsername(),
                product.getPrice(),
                product.getDescription()
        );
    }
}
