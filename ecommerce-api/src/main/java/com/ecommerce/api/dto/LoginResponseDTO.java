package com.ecommerce.api.dto;

public record LoginResponseDTO(
        String token,
        Long id,
        String name
) {
}
