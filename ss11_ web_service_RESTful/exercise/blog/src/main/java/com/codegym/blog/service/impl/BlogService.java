package com.codegym.blog.service.impl;

import com.codegym.blog.model.BlogModel;
import com.codegym.blog.repository.IBlogRepository;
import com.codegym.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;


    @Override
    public Page<BlogModel> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<BlogModel> findAllByCategory(int category_id, Pageable pageable) {
        return blogRepository.findAllByCategory_Id(category_id,pageable);
    }

    @Override
    public Page<BlogModel> findBlogsByTitleContainsOrContentContains(String title, String content, Pageable pageable) {
        return null;
    }

    @Override
    public List<BlogModel> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public List<BlogModel> findAllByCategory(int category_id) {
        return blogRepository.findAllByCategory_Id(category_id);
    }

    @Override
    public BlogModel findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public BlogModel save(BlogModel blog) {
        return blogRepository.save(blog);
    }

}
