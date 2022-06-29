package com.codegym.blog.controller;

import com.codegym.blog.model.BlogModel;
import com.codegym.blog.model.Category;
import com.codegym.blog.service.ICategoryService;
import com.codegym.blog.service.impl.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/categories")
@RestController
public class CategoryController {
    @Autowired
    private BlogService blogService;
    @Autowired
    ICategoryService categoryService;
    @GetMapping
    public ResponseEntity<?> categoryList() {
        List<Category> categories = categoryService.findAll();
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<BlogModel>> viewBlogListByCategory(@PathVariable int id) {
        List<BlogModel> blogs = blogService.findAllByCategory(id);
        if (blogs.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
}
