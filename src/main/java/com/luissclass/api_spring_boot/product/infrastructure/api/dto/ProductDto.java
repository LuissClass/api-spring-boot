package com.luissclass.api_spring_boot.product.infrastructure.api.dto;

public record ProductDto(
    Long id,
    String name,
    String description,
    Double price,
    String image
) {
}
