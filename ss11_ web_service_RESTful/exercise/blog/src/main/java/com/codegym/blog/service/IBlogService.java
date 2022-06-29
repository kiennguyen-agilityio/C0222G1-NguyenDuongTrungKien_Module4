package com.codegym.blog.service;

import com.codegym.blog.model.BlogModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<BlogModel> findAll(Pageable pageable);

    Page<BlogModel> findAllByCategory(int category_id, Pageable pageable);

    Page<BlogModel> findBlogsByTitleContainsOrContentContains(String title, String content, Pageable pageable);

    List<BlogModel> findAll();

    List<BlogModel> findAllByCategory(int category_id);

    BlogModel findById(int id);

    BlogModel save(BlogModel blog);

}
