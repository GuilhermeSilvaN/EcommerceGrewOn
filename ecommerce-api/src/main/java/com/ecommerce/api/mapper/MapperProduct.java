package com.ecommerce.api.mapper;

import com.ecommerce.api.dto.ProductDTO;
import com.ecommerce.api.dto.ProductDTOCreate;
import com.ecommerce.api.model.Product;

public class MapperProduct {
    public static Product productDTOCreateToProduct(ProductDTOCreate productDTOCreate) {
        return new Product(
                productDTOCreate.code(),
                productDTOCreate.img(),
                productDTOCreate.username(),
                productDTOCreate.price(),
                productDTOCreate.description()
        );
    }

    public static ProductDTO productEntityToProductDTO(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getCode(),
                product.getImg(),
                product.getUsername(),
                product.getPrice(),
                product.getDescription()
        );
    }

    public static void productUpdate(Product product, ProductDTOCreate productDTOCreate) {
        product.setCode(productDTOCreate.code());
        product.setImg(productDTOCreate.img());
        product.setUsername(productDTOCreate.username());
        product.setPrice(productDTOCreate.price());
        product.setDescription(productDTOCreate.description());
    }
}
