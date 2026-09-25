package com.luissclass.api_spring_boot.product.aplication.query.getById;

import com.luissclass.api_spring_boot.common.mediator.Request;

public record GetProductByIdRequest (
    Long id
) implements Request<GetProductByIdResponse>{
    
}
