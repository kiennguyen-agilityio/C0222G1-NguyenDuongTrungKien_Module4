package com.service.impl;

import com.model.Product;
import com.service.ProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    public static Map<Integer, Product> products = new HashMap<>();

    static {
        products.put(1, new Product(1, "Airblade", 1000, "mới 100%", "honda"));
        products.put(2, new Product(2, "Exiter", 2000, "mới 90%", "suzuki"));
        products.put(3, new Product(3, "Vision", 3000, "mới 80%", "honda"));
        products.put(4, new Product(4, "Winner X", 4000, "mới 70%", "honda"));
        products.put(5, new Product(5, "Kawasaki", 5000, "mới 60%", "honda"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {

        products.remove(id);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public List<Product> search(String name) {
        List<Product> productList = new ArrayList<>();
        for (Map.Entry<Integer, Product> item : products.entrySet()) {
            if (item.getValue().getName().toLowerCase().contains(name.toLowerCase())) {
                productList.add(item.getValue());
            }
        }
        return productList;
    }
}
