package com.luissclass.api_spring_boot.product.aplication.query.getAll;

import org.springframework.stereotype.Service;

import com.luissclass.api_spring_boot.common.mediator.RequestHandler;
import com.luissclass.api_spring_boot.product.domain.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GetAllProductHandler  implements RequestHandler<GetAllProductRequest, GetAllProductResponse> {
     private final ProductRepository productRepository;

    @Override
    public GetAllProductResponse handle(GetAllProductRequest request) {
        return new GetAllProductResponse(productRepository.findAll());
    }

    @Override
    public Class<GetAllProductRequest> getRequestType() {
        return GetAllProductRequest.class;
    }
}
