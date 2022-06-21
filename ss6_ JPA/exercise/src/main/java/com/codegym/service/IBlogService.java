package com.codegym.service;

import com.codegym.model.BlogModel;

import java.util.List;

public interface IBlogService {
    List<BlogModel> findAll();
    void save(BlogModel blogModel) ;
    void update(BlogModel blogModel) ;
    BlogModel findById(int id);
    void delete(int id);
    List<BlogModel> searchByName(String title);
}
