package com.adventureworks.products.domain.service.impl;

import com.adventureworks.products.domain.dto.CategoryDto;
import com.adventureworks.products.domain.service.ProductService;
import com.adventureworks.products.domain.dto.ProductDto;
import com.adventureworks.products.domain.mappers.ProductMapper;
import com.adventureworks.products.persistence.entity.Product;
import com.adventureworks.products.persistence.repository.CategoryRepository;
import com.adventureworks.products.persistence.repository.ProductRepository;
import com.adventureworks.products.web.advice.ResourceNotFoundException;
import com.adventureworks.products.web.request.FindProductRequest;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductDto> findByParams(FindProductRequest param) {
        var products = this.productRepository.findByParams(param);
        return this.productMapper.toProductsDto(products);
    }

    @Override
    public List<ProductDto> find(String name) {
        var products = this.productRepository.find(name);
        return this.productMapper.toProductsDto(products);
    }

    @Override
    public Product findById(Integer id) {
        if (id == 0) {
            throw new ResourceNotFoundException("No existe el Producto");
        }
        return this.productRepository.findById(id).get();
    }

    @Override
    public Product save(ProductDto productDto) {
        var productToSave = this.productMapper.toProduct(productDto);
        productToSave.setRowguid(UUID.randomUUID().toString());
        productToSave.setModifiedDate(new Date());
        return this.productRepository.save(productToSave);
    }

    @Override
    public Product update(ProductDto productDto) {
        var product = this.productRepository.findById(productDto.getId()).get();
        var productToSave = this.productMapper.toProductTarget(productDto, product);
        productToSave.setModifiedDate(new Date());
        return this.productRepository.save(productToSave);
    }

    @Override
    public CategoryDto getProductCategory(Integer id) {
        var product = this.productRepository.findById(id).get();
        return this.categoryRepository.findById(product.getCategoryId());
    }
}
