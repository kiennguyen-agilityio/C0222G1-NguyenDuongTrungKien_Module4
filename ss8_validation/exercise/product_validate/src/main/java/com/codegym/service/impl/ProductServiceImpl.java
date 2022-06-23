package com.codegym.service.impl;


import com.codegym.model.Product;
import com.codegym.repository.ProductRepo;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepo productRepo;

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public void save(Product product) {
        productRepo.save(product);
    }

    @Override
    public void update( Product product) {
        productRepo.update(product.getName(), product.getPrice(), product.getDescription(), product.getProducer(), product.getId());
    }

    @Override
    public void remove(int id) {
        productRepo.deleteProduct(id);
    }

    @Override
    public Product findById(int id) {
        return productRepo.getProductById(id);
    }

    @Override
    public Page<Product> findAllProductPage(Pageable pageable) {
        return productRepo.findAllProductPage(pageable);
    }

    @Override
    public Page<Product> searchProduct(String keyword, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Product> searchByProductName(String productName, Pageable pageable) {
        return productRepo.searchByProductName("%" + productName + "%", pageable);
    }
}
