package com.codegym.blog.controller;

import com.codegym.blog.model.BlogModel;
import com.codegym.blog.model.Category;
import com.codegym.blog.service.ICategoryService;
import com.codegym.blog.service.impl.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RequestMapping("/api/blog")
@RestController
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    ICategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<List<BlogModel>> blogList() {
        List<BlogModel> blogs = blogService.findAll();
        if (blogs.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogModel> viewBlog(@PathVariable int id) {
        BlogModel blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<BlogModel> saveBlog(@RequestBody BlogModel blogModel) {
        blogService.save(blogModel);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }


}
