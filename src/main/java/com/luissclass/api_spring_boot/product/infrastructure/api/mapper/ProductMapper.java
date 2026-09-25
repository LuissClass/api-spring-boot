package com.luissclass.api_spring_boot.product.infrastructure.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import com.luissclass.api_spring_boot.product.aplication.command.create.CreateProductRequest;
import com.luissclass.api_spring_boot.product.domain.Product;
import com.luissclass.api_spring_boot.product.infrastructure.api.dto.ProductDto;

@Mapper(componentModel  = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ProductMapper {
    CreateProductRequest toCreateProductRequest(ProductDto productDto);
    
    ProductDto toProductDto(Product product);
}