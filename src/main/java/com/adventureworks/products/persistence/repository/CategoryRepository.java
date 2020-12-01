package com.adventureworks.products.persistence.repository;

import com.adventureworks.products.domain.dto.CategoryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "BOOTCAMP-ADVENTUREWORKS-CATEGORIES")
public interface CategoryRepository {

    @GetMapping("categories/{id}")
    CategoryDto findById(@PathVariable("id") Integer id);

}
