package com.ecommerce.api.service;


import com.ecommerce.api.dto.ProductDTOCreate;
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

    public List<Product> findAll() {
        return productsRepository.findAll();
    }

    public Product findById(Long id) {
        return productsRepository.findById(id).get();
    }

    public Product save(ProductDTOCreate productDTOCreate) {
        Product product = new Product(
                productDTOCreate.code(),
                productDTOCreate.img(),
                productDTOCreate.username(),
                productDTOCreate.price(),
                productDTOCreate.description()
        );

        return productsRepository.save(product);
    }

}