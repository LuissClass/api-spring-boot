package com.luissclass.api_spring_boot.product.aplication.command.delete;

import com.luissclass.api_spring_boot.common.mediator.Request;

public record DeleteProductRequest (
    Long id
) implements Request<Void> {
    
}
