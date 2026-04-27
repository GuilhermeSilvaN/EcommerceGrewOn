package com.ecommerce.api.repository;

import com.ecommerce.api.model.OrderProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderProducts, Long> {
}
