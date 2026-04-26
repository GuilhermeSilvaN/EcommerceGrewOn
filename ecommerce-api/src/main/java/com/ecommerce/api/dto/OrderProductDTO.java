package com.ecommerce.api.dto;

import com.ecommerce.api.model.OrderProducts;
import com.ecommerce.api.model.UserEntity;

import java.util.List;

public record OrderProductDTO (
        Long id,
        UserEntity userEntity,
        List<OrderProducts> orderProducts
) {
    public OrderProductDTO(Long id, UserEntity userEntity, List<OrderProducts> orderProducts){
        this.id = id;
        this.userEntity = userEntity;
        this.orderProducts = orderProducts;
    }
}
