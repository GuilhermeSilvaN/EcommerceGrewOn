package com.ecommerce.api.service;


import com.ecommerce.api.dto.ProductDTO;
import com.ecommerce.api.dto.ProductDTOCreate;
import com.ecommerce.api.mapper.MapperProduct;
import com.ecommerce.api.model.Product;
import com.ecommerce.api.model.UserEntity;
import com.ecommerce.api.repository.ProductsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

    private ProductsRepository productsRepository;

    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    //list;
    public List<ProductDTO> findAll() {
        List<Product> products = productsRepository.findAll();

        return products.stream().map(MapperProduct::productEntityToProductDTO).toList();
    }

    //findById(long id);
    public ProductDTO findById(Long id) {
        Product product = productsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        return MapperProduct.productEntityToProductDTO(product);
    }

    //save;
    public ProductDTO save(ProductDTOCreate productDTOCreate) {
        Product product = new Product(
                productDTOCreate.code(),
                productDTOCreate.img(),
                productDTOCreate.username(),
                productDTOCreate.price(),
                productDTOCreate.description()
        );

        productsRepository.save(product);

        return MapperProduct.productEntityToProductDTO(product);
    }

    //update (Long id);
    public ProductDTO update(Long id, ProductDTOCreate productDTOCreate) {
        Product product = productsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        MapperProduct.productUpdate(product, productDTOCreate);
        productsRepository.save(product);

        return MapperProduct.productEntityToProductDTO(product);

    }

    //delete (Long id);
    public void deleteById(Long id) {
        Product  product = productsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        productsRepository.delete(product);
    }

}