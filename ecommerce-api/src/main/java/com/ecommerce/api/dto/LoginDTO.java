package com.ecommerce.api.dto;

public record LoginDTO(
        String email,
        String password
) {
    public LoginDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
