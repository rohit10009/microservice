package com.rohit.controller;

import com.rohit.model.ProductRequest;
import com.rohit.model.ProductResponse;
import com.rohit.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/")
    public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest){
       long productId= productService.addProduct(productRequest);
       return new ResponseEntity<>(productId, HttpStatus.CREATED);

    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable long id){
        ProductResponse productResponse= productService.getProductById(id);
        return new ResponseEntity<>(productResponse,HttpStatus.OK);

    }


}
