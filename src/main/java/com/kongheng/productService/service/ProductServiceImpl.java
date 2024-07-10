package com.kongheng.productService.service;

import com.kongheng.productService.entity.Product;
import com.kongheng.productService.entity.ProductResponse;
import com.kongheng.productService.exception.ProductServiceCustomException;
import com.kongheng.productService.model.ProductRequest;
import com.kongheng.productService.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public long addProduct(ProductRequest request) {
        Product product = Product.builder()
            .productName(request.getName())
            .quantity(request.getQuantity())
            .price(request.getPrice())
            .build();
        productRepository.save(product);
        return product.getProductId();
    }

    @Override
    public ProductResponse getProductById(long productId) {
        Product product = productRepository.findById(productId)
            .orElseThrow(
                () -> new ProductServiceCustomException("Product with given id not found", "PRODUCT_NOT_FOUND")
            );
        ProductResponse productResponse = new ProductResponse();
        BeanUtils.copyProperties(product, productResponse);
        return productResponse;
    }
}
