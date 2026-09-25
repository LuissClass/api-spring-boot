package com.luissclass.api_spring_boot.product.infrastructure.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.luissclass.api_spring_boot.product.infrastructure.api.dto.ProductDto;

public interface ProductController {
    public ResponseEntity<List<ProductDto>> getAllProducts();
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id);
    public ResponseEntity<Void> saveProduct(@RequestBody ProductDto productDto);
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto);
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id);
}