package com.adventureworks.products.web.controller;

import com.adventureworks.products.domain.dto.CategoryDto;
import com.adventureworks.products.domain.service.ProductService;
import com.adventureworks.products.domain.dto.ProductDto;
import com.adventureworks.products.persistence.entity.Product;
import com.adventureworks.products.web.request.FindProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller()
@RequestMapping("products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    ResponseEntity<Product> getByIdProduct(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(this.productService.findById(id), HttpStatus.OK);
    }

    @GetMapping()
    ResponseEntity<List<ProductDto>> findAll(@RequestParam("name") Optional<String> name) {
         return new ResponseEntity<>(this.productService.find(name.isPresent() ? name.get() : ""), HttpStatus.OK);
    }

    @GetMapping("/find")
    ResponseEntity<List<ProductDto>> findAll(@Valid FindProductRequest param){
        return new ResponseEntity<>(this.productService.findByParams(param), HttpStatus.OK);
    }

    @PostMapping()
    ResponseEntity<Product> save(@RequestBody() ProductDto productDto){
        return new ResponseEntity<>(this.productService.save(productDto), HttpStatus.CREATED);
    }

    @PutMapping()
    ResponseEntity<Product> update(@RequestBody() ProductDto productDto){
        return new ResponseEntity<>(this.productService.update(productDto), HttpStatus.OK);
    }

    @GetMapping("/{id}/category")
    ResponseEntity<CategoryDto> getProductCategory(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(this.productService.getProductCategory(id), HttpStatus.OK);
    }

}
