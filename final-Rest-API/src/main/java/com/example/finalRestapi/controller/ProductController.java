package com.example.finalRestapi.controller;

import com.example.finalRestapi.entity.ProductEntity;
import com.example.finalRestapi.mapper.ProductMapper;
import com.example.finalRestapi.model.Product;
import com.example.finalRestapi.repository.ProductRepository;
import com.example.finalRestapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    private final ProductMapper productMapper;

    @Autowired
    private final ProductEntity productEntity;

    @Autowired
    private final ProductService productService;

    public ProductController(ProductRepository productRepository, ProductMapper productMapper, ProductEntity productEntity, ProductService productService) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.productEntity = productEntity;
        this.productService = productService;
    }

    @PostMapping(path = "/products")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        product = productService.saveProduct(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @GetMapping(path = "/products")
    public ResponseEntity<List<Product>> listOfAll(Product product) {
        product= (Product) productService.listOfAll(product);
        return new ResponseEntity<List<Product>>((List<Product>) product, HttpStatus.OK);

    }
}
