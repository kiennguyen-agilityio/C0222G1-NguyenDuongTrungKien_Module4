package com.codegym.blog.controller.rest;

import com.codegym.blog.model.Blog;
import com.codegym.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;

    @GetMapping
    public ResponseEntity<?> showAll(@RequestParam(name = "page", defaultValue = "0") int page) {
        Sort sort = Sort.by("creating_date").descending();
        Page<Blog> blogs = blogService.findAll(PageRequest.of(page, 2, sort));
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findBlogById(@PathVariable Integer id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Blog blog) {
        blogService.save(blog);
        return new ResponseEntity<>(blog, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> update(@PathVariable Integer id, @RequestBody Blog blog) {
        Blog returnBlog = blogService.findById(id);
        if (returnBlog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blog.setId(returnBlog.getId());
        blogService.save(blog);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.remove(id);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @GetMapping("/search/{title}")
    ResponseEntity<?> search(@PathVariable("title")  String title) {
        List<Blog> blogList = blogService.searchByTitle(title);
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }

    @GetMapping("/load/{size}")
    public ResponseEntity<?> loadPage(@PathVariable("size") Integer size,
                                      @RequestParam(name="page",defaultValue = "0") Integer page){
        Page<Blog> blogPage=blogService.findAll(PageRequest.of(page,size));
        return new ResponseEntity<>(blogPage.getContent(),HttpStatus.OK); //.getContent : chuyển page thành list
    }
}