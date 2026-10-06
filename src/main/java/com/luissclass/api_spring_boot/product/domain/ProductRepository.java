package com.luissclass.api_spring_boot.product.domain;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    void upsert(Product product);
    void deleteById(Long id);
}
