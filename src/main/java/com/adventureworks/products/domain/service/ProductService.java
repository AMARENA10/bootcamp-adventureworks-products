package com.adventureworks.products.domain.service;

import com.adventureworks.products.domain.dto.CategoryDto;
import com.adventureworks.products.domain.dto.ProductDto;
import com.adventureworks.products.persistence.entity.Product;
import com.adventureworks.products.web.request.FindProductRequest;

import java.util.List;

public interface ProductService {
    List<ProductDto> findByParams(FindProductRequest param);
    List<ProductDto> find(String name);
    Product findById(Integer id);
    Product save(ProductDto productDto);
    Product update(ProductDto productDto);

    CategoryDto getProductCategory(Integer id);
}
