package com.codegym.service;


import com.codegym.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void save(Product product);

    void update( Product product);

    void remove(int id);

    Product findById(int id);

    Page<Product> findAllProductPage(Pageable pageable);

    Page<Product> searchProduct(String keyword, Pageable pageable);

    Page<Product> searchByProductName(String productName, Pageable pageable);
}
