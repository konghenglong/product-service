package com.kongheng.productService.service;

import com.kongheng.productService.entity.ProductResponse;
import com.kongheng.productService.model.ProductRequest;

public interface ProductService {

    long addProduct(ProductRequest request);

    ProductResponse getProductById(long productId);

    void reduceQuantity(long productId, long quantity);
}
