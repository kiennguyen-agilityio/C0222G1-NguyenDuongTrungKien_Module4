package com.codegym.blog.controller;

import com.codegym.blog.model.BlogModel;
import com.codegym.blog.service.ICategoryService;
import com.codegym.blog.service.impl.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    ICategoryService categoryService;


    @GetMapping("")
    public String index(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Sort sort = Sort.by("create_date").ascending();
        Page<BlogModel> list = blogService.findAllBlog(PageRequest.of(page, 1, sort));
        model.addAttribute("list", list);
        return "blog/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new BlogModel());
        model.addAttribute("categoryList", categoryService.findAll());
        return "create";
    }

    @PostMapping("/save")
    public String save(BlogModel blogModel, RedirectAttributes redirect) {
        blogService.save(blogModel);
        redirect.addFlashAttribute("success", "Saved customer successfully!");
        return "redirect:/list";
    }

    @RequestMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("blog", blogService.findById(id));
        return "edit";
    }

    @PostMapping("/blog/update")
    public String update(BlogModel blogModel, RedirectAttributes redirect) {
        blogService.update(blogModel);
        redirect.addFlashAttribute("success", "Modified product successfully!");
        return "redirect:/list";
    }

    @RequestMapping("/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirect) {
        blogService.delete(id);
        redirect.addFlashAttribute("success", "Deleted success");
        return "redirect:/list";
    }

    @GetMapping("/{id}/read")
    public String showRead(@PathVariable Integer id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "view";
    }

    @GetMapping("/search")
    public String searchByTitle(@RequestParam(name = "page", defaultValue = "0") int page, BlogModel blogModel, Model model) {
        Pageable pageable;
        Sort sort = Sort.by("create_day").ascending();
        pageable = PageRequest.of(page, 10, sort);
        Page<BlogModel> blogList = blogService.searchByTitle(blogModel.getTitle(), pageable);
        model.addAttribute("blogList", blogList);
        return "index";
    }
}
