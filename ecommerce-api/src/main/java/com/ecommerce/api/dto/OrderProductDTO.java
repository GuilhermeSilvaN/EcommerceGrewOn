package com.ecommerce.api.dto;

import com.ecommerce.api.model.Product;
import com.ecommerce.api.model.UserEntity;

import java.util.List;

public record OrderProductDTO (
        Long id,
        UserEntity userEntity,
        List<Product> products
) {
    public OrderProductDTO(Long id, UserEntity userEntity, List<Product> products) {
        this.id = id;
        this.userEntity = userEntity;
        this.products = products;
    }
}
