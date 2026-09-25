package com.luissclass.api_spring_boot.product.aplication.query.getById;

import org.springframework.stereotype.Service;

import com.luissclass.api_spring_boot.common.mediator.RequestHandler;
import com.luissclass.api_spring_boot.product.domain.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GetProductByIdHandler implements RequestHandler<GetProductByIdRequest, GetProductByIdResponse> {
    private final ProductRepository productRepository;

    @Override
    public GetProductByIdResponse handle(GetProductByIdRequest request) {
        return new GetProductByIdResponse(
                productRepository
                        .findById(request.id())
                        .orElseThrow(() -> new IllegalArgumentException("Product not found")));
    }

    @Override
    public Class<GetProductByIdRequest> getRequestType() {
        return GetProductByIdRequest.class;
    }

}
