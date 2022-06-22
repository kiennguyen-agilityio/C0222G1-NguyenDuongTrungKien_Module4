package com.codegym.blog.service;

import com.codegym.blog.model.BlogModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<BlogModel> findAll();

    void save(BlogModel blogModel);

    void update(BlogModel blogModel);

    BlogModel findById(int id);

    void delete(int id);

    Page<BlogModel> findAllBlog(Pageable pageable);

    Page<BlogModel> searchBlog(String keyword, Pageable pageable);

    Page <BlogModel> searchByTitle(String title, Pageable pageable);
}
