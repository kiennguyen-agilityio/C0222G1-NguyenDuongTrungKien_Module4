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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
@Controller
@RequestMapping("/api/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    ICategoryService categoryService;

    @GetMapping("")
    public List<BlogModel> blogList(Model model) {
        List<BlogModel> blogs = blogService.findAll();
        return 
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


    @RequestMapping(value = {"/search"}, method = RequestMethod.GET)
    public ModelAndView sortedList(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "") String search) {
        int pageSize = 5;
        ModelAndView model = new ModelAndView("result");
        List<BlogModel> blogs = new ArrayList<>();
        if (search.equals("")) {
            for (int i = 0; i <= page; i++) {
                Pageable pageable = PageRequest.of(page, pageSize);
                blogs.addAll(blogService.findAll(pageable).getContent());
            }
            Pageable pageable = PageRequest.of(page + 1, pageSize);
            boolean more = blogService.findAll(pageable) != null;
            model.addObject("more", more);
        } else {
            for (int i = 0; i <= page; i++) {
                Pageable pageable = PageRequest.of(page, pageSize);
                blogs.addAll(blogService.findAllByTitleContains(search, pageable).getContent());
            }
            Pageable pageable = PageRequest.of(page + 1, pageSize);
            boolean more = blogService.findAllByTitleContains(search, pageable) != null;
            model.addObject("more", more);
        }
        model.addObject("search", search);
        model.addObject("page", page + 1);
        model.addObject("blogs", blogs);
        return model;
    }

}
