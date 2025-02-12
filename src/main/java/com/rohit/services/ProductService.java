package com.rohit.services;

import com.rohit.model.ProductRequest;
import com.rohit.model.ProductResponse;

public interface ProductService{
    long addProduct(ProductRequest productRequest);

    ProductResponse getProductById(long id);
}
