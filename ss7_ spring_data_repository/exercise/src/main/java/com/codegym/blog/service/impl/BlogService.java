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
    public List<BlogModel> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public void save(BlogModel blogModel) {
        blogRepository.save(blogModel);
    }

    @Override
    public void update(BlogModel blogModel) {
        blogRepository.update(blogModel.getTitle(),
                                blogModel.getContent(),
                                blogModel.getCreateDate(),
                                blogModel.getCategory().getId(),
                                blogModel.getId());
    }

    @Override
    public BlogModel findById(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        blogRepository.delete(id);
    }


    @Override
    public Page<BlogModel> findAllBlog(Pageable pageable) {
        return blogRepository.findAllBlog(pageable);
    }

    @Override
    public Page<BlogModel> searchBlog(String keyword, Pageable pageable) {
        return blogRepository.findAllByTitleContaining(keyword,pageable);
    }

    @Override
    public Page<BlogModel> searchByTitle(String title, Pageable pageable) {
        return blogRepository.searchByTitle(title,pageable);
    }
}
