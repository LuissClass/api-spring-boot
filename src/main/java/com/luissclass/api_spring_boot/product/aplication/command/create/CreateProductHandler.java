package com.luissclass.api_spring_boot.product.aplication.command.create;

import org.springframework.stereotype.Service;

import com.luissclass.api_spring_boot.common.mediator.RequestHandler;
import com.luissclass.api_spring_boot.product.domain.Product;
import com.luissclass.api_spring_boot.product.domain.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor
public class CreateProductHandler implements RequestHandler<CreateProductRequest, Void> {
    private final ProductRepository productRepository;

    @Override
    public Void handle(CreateProductRequest request) {
        Product product = new Product(request.id(), request.name(), request.description(), request.price(), request.image());

        productRepository.save(product);
        return null;
    }

    @Override
    public Class<CreateProductRequest> getRequestType() {
        return CreateProductRequest.class;
    }

}
