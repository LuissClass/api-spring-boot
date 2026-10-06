package com.luissclass.api_spring_boot.product.infrastructure.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.luissclass.api_spring_boot.product.domain.Product;
import com.luissclass.api_spring_boot.product.domain.ProductRepository;
import com.luissclass.api_spring_boot.product.infrastructure.database.entity.ProductEntity;
import com.luissclass.api_spring_boot.product.infrastructure.database.mapper.ProductEntityMapper;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {
    private final List<ProductEntity> products = new ArrayList<>();
    private final ProductEntityMapper productEntityMapper;

    @Override
    public List<Product> findAll() {
        return products.stream()
                .map(productEntityMapper::toProduct)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Product> findById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .map(productEntityMapper::toProduct);
    }

    @Override
    public void upsert(Product product) {
        ProductEntity productEntity = productEntityMapper.toProductEntity(product);
        products.removeIf(p -> p.getId().equals(productEntity.getId()));
        products.add(productEntity);
    }

    @Override
    public void deleteById(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }
}