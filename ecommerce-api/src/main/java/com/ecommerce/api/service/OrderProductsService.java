package com.ecommerce.api.service;

import com.ecommerce.api.dto.OrderProductDTO;
import com.ecommerce.api.dto.OrderProductDTOCreate;
import com.ecommerce.api.mapper.MapperOrderProduct;
import com.ecommerce.api.model.OrderItem;
import com.ecommerce.api.model.UserEntity;
import com.ecommerce.api.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderProductsService {
    private OrderRepository orderRepository;

    public  OrderProductsService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderProductDTO> findAll(){
        List<OrderItem> orderProducts = orderRepository.findAll();
        return orderProducts.stream().map(MapperOrderProduct::orderProductToOrderProductDTO).toList();
    }

    public List<OrderItem> findByUser_Id(UserEntity user){
        return orderRepository.findByUser(user);
    }

    public OrderItem findById(Long id){
        return orderRepository.findById(id).get();
    }

    public OrderItem save(OrderProductDTOCreate orderProductDTOCreate){
        OrderItem orderItem = new OrderItem(
                orderProductDTOCreate.userEntity(),
                orderProductDTOCreate.products()
        );

        return orderRepository.save(orderItem);
    }
}
