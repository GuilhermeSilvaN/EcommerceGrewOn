package com.ecommerce.api.repository;

import com.ecommerce.api.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRespository extends JpaRepository<UserEntity, Long> {
}
