package com.example.finalRestapi.mapper;

import com.example.finalRestapi.entity.ProductEntity;
import com.example.finalRestapi.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE= Mappers.getMapper(ProductMapper.class);

    Product entityToProducts(ProductEntity productEntity);
    ProductEntity productsToEntity(Product product);

}
