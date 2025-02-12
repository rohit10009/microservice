package com.rohit.services;

import com.rohit.entities.Product;
import com.rohit.exceptions.ProductServiceCustomException;
import com.rohit.model.ProductRequest;
import com.rohit.model.ProductResponse;
import com.rohit.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService{

    @Autowired
   private ProductRepository productRepository;
    @Override
    public long addProduct(ProductRequest productRequest) {
     log.info("adding product");
        Product product=Product.builder()
                .productName(productRequest.getName())
                .quantity(productRequest.getQuantity())
                .price(productRequest.getPrice())
                .build();
                 productRepository.save(product);
                 log.info("product created");
        return product.getProductId();
    }

    @Override
    public ProductResponse getProductById(long id) {
        log.info("getting product by id",id);
        Product product=productRepository.findById(id)
                .orElseThrow(
                        ()->new ProductServiceCustomException("product with given id not found","Product not found")
                );
        ProductResponse productResponse=new ProductResponse();
        BeanUtils.copyProperties(product,productResponse);
        return productResponse;
    }

}
