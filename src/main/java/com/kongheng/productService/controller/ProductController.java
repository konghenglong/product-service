package com.kongheng.productService.controller;

import com.kongheng.productService.entity.ProductResponse;
import com.kongheng.productService.model.ProductRequest;
import com.kongheng.productService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Long> addProduct(@RequestBody ProductRequest request) {
        return ResponseEntity.ok().body(productService.addProduct(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") long productId) {
        return ResponseEntity.ok().body(productService.getProductById(productId));
    }

    @PutMapping("/reduceQuantity/{id}")
    public ResponseEntity<Void> reduceQuantity(
        @PathVariable("id") long productId, @RequestParam long quantity) {
        productService.reduceQuantity(productId, quantity);
        return ResponseEntity.noContent().build();
    }

}
