package codegym.service.impl;

import codegym.model.Product;
import codegym.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductServiceImpl productService = new ProductServiceImpl();

    @Override
    public List<Product> findAll() {
        return productService.findAll();
    }

    @Override
    public void save(Product product) {
        productService.save(product);
    }

    @Override
    public void update(int id, Product product) {
        productService.update(id, product);
    }

    @Override
    public void remove(int id) {
        productService.remove(id);
    }

    @Override
    public Product findById(int id) {
        return productService.findById(id);
    }

    @Override
    public List<Product> search(String name) {
        return productService.search(name);
    }
}
