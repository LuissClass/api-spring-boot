package com.luissclass.api_spring_boot.product.aplication.query.getById;

import com.luissclass.api_spring_boot.product.domain.Product;

public record GetProductByIdResponse (
    Product product
) {
}
