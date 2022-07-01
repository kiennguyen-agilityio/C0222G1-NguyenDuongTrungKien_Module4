package com.codegym.blog.service;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageble);

    void save(Blog blog);

    Blog findById(int id);

    void update(Blog blog);

    void remove(Integer id);

    Page<Blog> searchByName(String title, String categoryName, Pageable pageble);

    List<Blog> findAllByCategoryContaining(Category category);

    List<Blog> searchByTitle (String title);

}
