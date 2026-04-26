package com.ecommerce.api.dto;

import com.ecommerce.api.model.OrderProducts;
import com.ecommerce.api.model.Product;
import com.ecommerce.api.model.UserEntity;

import java.util.List;

public record OrderProductDTOCreate (
        UserEntity userEntity,
        List<Product> products
) {
    public OrderProductDTOCreate(UserEntity userEntity, List<Product> products) {
        this.userEntity = userEntity;
        this.products = products;
    }
}
