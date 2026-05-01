package com.ecommerce.api.controller;

import com.ecommerce.api.dto.ProductDTO;
import com.ecommerce.api.dto.ProductDTOCreate;
import com.ecommerce.api.service.ProductsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private ProductsService productsService;

    public ProductsService getProductsService() {
        return productsService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        return ResponseEntity.ok().body(productsService.findAll());
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTOCreate productDTOCreate){
        ProductDTO product = productsService.save(productDTOCreate);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(product.id()).toUri();

        return ResponseEntity.created(uri).body(product);
    }

    @PutMapping
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody ProductDTOCreate productDTOCreate){
        ProductDTO product = productsService.update(id, productDTOCreate);
        return ResponseEntity.ok().body(product);
    }
}
