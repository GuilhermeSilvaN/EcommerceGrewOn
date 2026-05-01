package com.ecommerce.api.repository;

import com.ecommerce.api.model.OrderItem;
import com.ecommerce.api.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findByUser(UserEntity user);
}
