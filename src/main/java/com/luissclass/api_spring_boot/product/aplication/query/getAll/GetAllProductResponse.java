package com.luissclass.api_spring_boot.product.aplication.query.getAll;

import java.util.List;

import com.luissclass.api_spring_boot.product.domain.Product;

public record GetAllProductResponse (
    List<Product> products
) {
}
