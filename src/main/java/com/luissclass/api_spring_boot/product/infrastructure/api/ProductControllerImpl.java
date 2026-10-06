package com.luissclass.api_spring_boot.product.infrastructure.api;

import java.net.URI;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luissclass.api_spring_boot.common.mediator.Mediator;
import com.luissclass.api_spring_boot.product.aplication.command.create.CreateProductRequest;
import com.luissclass.api_spring_boot.product.aplication.command.delete.DeleteProductRequest;
import com.luissclass.api_spring_boot.product.aplication.command.update.UpdateProductRequest;
import com.luissclass.api_spring_boot.product.aplication.query.getAll.GetAllProductRequest;
import com.luissclass.api_spring_boot.product.aplication.query.getAll.GetAllProductResponse;
import com.luissclass.api_spring_boot.product.aplication.query.getById.GetProductByIdRequest;
import com.luissclass.api_spring_boot.product.aplication.query.getById.GetProductByIdResponse;
import com.luissclass.api_spring_boot.product.infrastructure.api.dto.ProductDto;
import com.luissclass.api_spring_boot.product.infrastructure.api.mapper.ProductMapper;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductControllerImpl implements ProductController {

        private final Mediator mediator;
        private final ProductMapper productMapper;

        @GetMapping("")
        public ResponseEntity<List<ProductDto>> getAllProducts() {
                GetAllProductResponse response = mediator.dispatch(new GetAllProductRequest());
                List<ProductDto> productsDtos = response.products()
                .stream().map(productMapper::toProductDto).toList();
                return ResponseEntity.ok(productsDtos);
        }

        @GetMapping("/{id}")
        public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
                GetProductByIdResponse response = mediator.dispatch(new GetProductByIdRequest(id));
                ProductDto productDto = productMapper.toProductDto(response.product());

                return ResponseEntity.ok(productDto);
        }

        @PostMapping("")
        public ResponseEntity<Void> saveProduct(@RequestBody ProductDto productDto) {
                CreateProductRequest request = productMapper.toCreateProductRequest(productDto);
                mediator.dispatch(request);
                return ResponseEntity.created(URI.create("/api/v1/products/".concat(productDto.id().toString()))).build();
        }

        @PutMapping("")
        public ResponseEntity<Void> updateProduct(@RequestBody ProductDto productDto) {
                UpdateProductRequest request = productMapper.toUpdateProductRequest(productDto);
                mediator.dispatch(request);
                return ResponseEntity.noContent().build();
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
                DeleteProductRequest request = productMapper.toDeleteProductRequest(id);
                mediator.dispatch(request);

                return ResponseEntity.noContent().build();
        }
}
