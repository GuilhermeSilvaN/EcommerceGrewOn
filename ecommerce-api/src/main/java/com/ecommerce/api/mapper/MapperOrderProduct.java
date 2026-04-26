package com.ecommerce.api.mapper;

import com.ecommerce.api.dto.OrderProductDTO;
import com.ecommerce.api.dto.OrderProductDTOCreate;
import com.ecommerce.api.model.OrderProducts;
import com.ecommerce.api.model.UserEntity;

public class MapperOrderProduct{
    public static OrderProducts productDTOCreateToOrderProducts(OrderProductDTOCreate orderProductDTOCreate){
        return new OrderProducts(
                orderProductDTOCreate.userEntity(),
                orderProductDTOCreate.products()
        );
    }

    public static OrderProductDTO orderProductToOrderProductDTO(OrderProducts orderProducts){
        return new OrderProductDTO(
                orderProducts.getId(),
                orderProducts.getUser(),
                orderProducts.getProducts()
        );
    }

    public static void updateOrderProducts(OrderProducts orderProducts, OrderProductDTOCreate orderProductDTOCreate){
        orderProducts.setProducts(orderProductDTOCreate.products());
    }
}
