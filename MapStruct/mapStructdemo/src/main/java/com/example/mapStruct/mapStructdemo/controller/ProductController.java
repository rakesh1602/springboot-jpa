package com.example.mapStruct.mapStructdemo.controller;

import com.example.mapStruct.mapStructdemo.dto.ProductDto;
import com.example.mapStruct.mapStructdemo.mapper.ProductMapper;
import com.example.mapStruct.mapStructdemo.model.Product;
import com.example.mapStruct.mapStructdemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/products")
    public ResponseEntity<Product> save(@RequestBody ProductDto productDto){
        return new ResponseEntity<>(productRepository.save(productMapper.dtoTOModel(productDto)), HttpStatus.CREATED);
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> findAll(){
       return new ResponseEntity<>(productMapper.modelsToDto(productRepository.findAll()),HttpStatus.OK);

    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> findById(@PathVariable(value = "id")Integer id){
        return new ResponseEntity<>(productMapper.modelToDto(productRepository.findById(id).get()),HttpStatus.OK);

    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(value = "id")Integer id){
       ProductDto productDto=productMapper.modelToDto(productRepository.findById(id).get());
       productRepository.deleteById(productDto.getId());
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
