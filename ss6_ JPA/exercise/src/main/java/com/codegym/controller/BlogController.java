package com.codegym.controller;

import com.codegym.model.BlogModel;
import com.codegym.service.impl.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @PostMapping("/list")
    public String index(Model model) {
        List<BlogModel> blog = blogService.findAll();
        model.addAttribute("blog", blog);
        return "index";
    }

    @GetMapping("blog/create")
    public String create(Model model) {
        model.addAttribute("blog", new BlogModel());
        return "create";
    }

    @PostMapping("blog/save")
    public String save(BlogModel blogModel, RedirectAttributes redirect) {
        blogService.save(blogModel);
        redirect.addFlashAttribute("success", "Saved customer successfully!");
        return "redirect:/list";
    }

    @RequestMapping("/blog/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "edit";
    }

    @PostMapping("/blog/update")
    public String update(BlogModel blogModel, RedirectAttributes redirect) {
        blogService.update(blogModel);
        redirect.addFlashAttribute("success", "Modified product successfully!");
        return "redirect:/list";
    }

    @RequestMapping("/blog/{id}/delete")
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
    public String searchByName(String title, Model model) {
        model.addAttribute("blogList", blogService.searchByName(title));
        return "index";
    }
}
