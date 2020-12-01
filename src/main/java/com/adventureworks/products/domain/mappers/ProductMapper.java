package com.adventureworks.products.domain.mappers;

import com.adventureworks.products.domain.dto.ProductDto;
import com.adventureworks.products.persistence.entity.Product;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "number", target = "productNumber")
    })
    Product toProduct(ProductDto dto);

    @Mappings({
            @Mapping(source = "number", target = "productNumber")
    })
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Product toProductTarget(ProductDto dto, @MappingTarget Product product);

    @Mappings({
            @Mapping(source = "productNumber", target = "number")
    })
    ProductDto toProductDto(Product entity);

    List<ProductDto> toProductsDto(List<Product> entity);

}
