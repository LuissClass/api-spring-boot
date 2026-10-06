package com.luissclass.api_spring_boot.product.aplication.command.delete;

import org.springframework.stereotype.Service;

import com.luissclass.api_spring_boot.common.mediator.RequestHandler;
import com.luissclass.api_spring_boot.product.domain.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor
public class DeleteProductHandler implements RequestHandler<DeleteProductRequest, Void> {
    private final ProductRepository productRepository;

    @Override
    public Void handle(DeleteProductRequest request) {
        productRepository.deleteById(request.id());
        return null;
    }

    @Override
    public Class<DeleteProductRequest> getRequestType() {
        return DeleteProductRequest.class;
    }
    
}
