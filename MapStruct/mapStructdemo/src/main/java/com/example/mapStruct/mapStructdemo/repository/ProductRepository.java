package com.example.mapStruct.mapStructdemo.repository;

import com.example.mapStruct.mapStructdemo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
