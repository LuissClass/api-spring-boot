package com.luissclass.api_spring_boot.product.aplication.command.update;

import org.springframework.stereotype.Service;

import com.luissclass.api_spring_boot.common.mediator.RequestHandler;
import com.luissclass.api_spring_boot.product.domain.Product;
import com.luissclass.api_spring_boot.product.domain.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor
public class UpdateProductHandler implements RequestHandler<UpdateProductRequest, Void>{
    private final ProductRepository productRepository;

    @Override
    public Void handle(UpdateProductRequest request) {
        Product product = new Product(request.id(), request.name(), request.description(), request.price(), request.image());
        productRepository.upsert(product);
        return null;
    }

    @Override
    public Class<UpdateProductRequest> getRequestType() {
        return UpdateProductRequest.class;
    }
    
}
