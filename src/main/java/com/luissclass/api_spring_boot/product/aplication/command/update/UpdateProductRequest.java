package com.luissclass.api_spring_boot.product.aplication.command.update;

import com.luissclass.api_spring_boot.common.mediator.Request;

public record UpdateProductRequest(
    Long id, 
    String name,
    String description,
    Double price,
    String image
) implements Request<Void> {
    
}