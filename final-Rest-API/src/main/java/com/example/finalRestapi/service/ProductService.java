package com.example.finalRestapi.service;

import com.example.finalRestapi.entity.ProductEntity;
import com.example.finalRestapi.mapper.ProductMapper;
import com.example.finalRestapi.model.Product;
import com.example.finalRestapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    private final ProductMapper productMapper;

    @Autowired
    private final ProductEntity productEntity;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper, ProductEntity productEntity) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.productEntity = productEntity;
    }

    public Product saveProduct(Product product){
     Product products= (Product) productRepository.save(productMapper.entityToProducts(productEntity));
        return products;
    }

    public List<Product> listOfAll(Product product){
        return productRepository.findAll();
    }
}
