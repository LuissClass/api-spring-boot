package com.luissclass.api_spring_boot.product.aplication.command.create;

import com.luissclass.api_spring_boot.common.mediator.Request;

public record CreateProductRequest(
    Long id, 
    String name,
    String description,
    Double price,
    String image
) implements Request<Void> {
} 