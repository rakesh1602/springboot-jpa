package com.example.mapStruct.mapStructdemo.mapper;

import com.example.mapStruct.mapStructdemo.dto.ProductDto;
import com.example.mapStruct.mapStructdemo.model.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.UUID;


@Mapper (componentModel = "spring", imports = UUID.class)
public interface ProductMapper {
    ProductMapper INSTANCE=Mappers.getMapper(ProductMapper.class);

    //@Mapping(source= "product.desc", target = "description", defaultValue = "description")
    //@Mapping(target = "id", expression = "java(UUID.randomUUID())")
   // @Mapping(source = "product.items", target = "itemList")

    ProductDto modelToDto(Product product);
    List<ProductDto> modelsToDto(List<Product> product);

    //Another method of Mapping
    @InheritInverseConfiguration
    Product dtoTOModel(ProductDto productDto);
}
