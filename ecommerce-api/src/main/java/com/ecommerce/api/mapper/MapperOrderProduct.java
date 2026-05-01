package com.ecommerce.api.mapper;

import com.ecommerce.api.dto.OrderProductDTO;
import com.ecommerce.api.dto.OrderProductDTOCreate;
import com.ecommerce.api.model.OrderItem;

public class MapperOrderProduct{
    public static OrderItem productDTOCreateToOrderProducts(OrderProductDTOCreate orderProductDTOCreate){
        return new OrderItem(
                orderProductDTOCreate.userEntity(),
                orderProductDTOCreate.products()
        );
    }

    public static OrderProductDTO orderProductToOrderProductDTO(OrderItem orderItem){
        return new OrderProductDTO(
                orderItem.getId(),
                orderItem.getUser(),
                orderItem.getProducts()
        );
    }

    public static void updateOrderProducts(OrderItem orderItem, OrderProductDTOCreate orderProductDTOCreate){
        orderItem.setProducts(orderProductDTOCreate.products());
    }
}
