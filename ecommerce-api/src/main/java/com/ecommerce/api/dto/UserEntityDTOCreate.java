package com.ecommerce.api.dto;

import com.ecommerce.api.model.UserEntity;

public record UserEntityDTOCreate(
        String username,
        String email,
        String password,
        Boolean isActive
) {
    public UserEntityDTOCreate (
            String username, String email, String password,  Boolean isActive
    ) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.isActive = isActive;
    }
    public UserEntityDTOCreate (
            UserEntity userEntity
    ){
        this(
                userEntity.getUsername(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.getIsActive()
        );
    }

}
