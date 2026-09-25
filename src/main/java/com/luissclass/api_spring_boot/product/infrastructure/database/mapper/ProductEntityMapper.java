package com.luissclass.api_spring_boot.product.infrastructure.database.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import com.luissclass.api_spring_boot.product.domain.Product;
import com.luissclass.api_spring_boot.product.infrastructure.database.entity.ProductEntity;

@Mapper(componentModel  = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ProductEntityMapper {
    ProductEntity toProductEntity(Product product);
    Product toProduct(ProductEntity productEntity);
    
} 