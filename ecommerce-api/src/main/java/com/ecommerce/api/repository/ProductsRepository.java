package com.ecommerce.api.repository;

import com.ecommerce.api.model.Product;
import com.ecommerce.api.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Long> {
}
