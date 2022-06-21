package com.codegym.service.impl;

import com.codegym.model.BlogModel;
import com.codegym.repository.IBlogRepository;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository ;
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
        blogRepository.update(blogModel.getTitle(),blogModel.getContent(),blogModel.getId()) ;
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
    public List<BlogModel> searchByName(String title) {
        return blogRepository.search(title);
    }


}
