package com.adventureworks.products.persistence.repository;

import com.adventureworks.products.persistence.entity.Product;
import com.adventureworks.products.web.request.FindProductRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    //    @Query("SELECT p FROM Product p WHERE UPPER(name) LIKE CONCAT('%',UPPER(?1),'%')  ")
    @Query("SELECT p FROM Product p WHERE UPPER(name) LIKE CONCAT('%',UPPER(:#{#name}),'%')  ")
    List<Product> find(String name);

    @Query("SELECT p FROM Product p " +
            "WHERE UPPER(p.name) LIKE CONCAT('%',UPPER(:#{#param.name}),'%') " +
            "AND p.color=:#{#param.color} " +
            "AND p.size=:#{#param.size} " +
            "AND p.weight<:#{#param.weight}")
    List<Product> findByParams(@Param("param") FindProductRequest param);

}
