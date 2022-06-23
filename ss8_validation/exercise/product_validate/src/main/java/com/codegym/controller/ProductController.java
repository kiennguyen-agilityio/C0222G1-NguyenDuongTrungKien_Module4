package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService service;
//
//    @GetMapping("/")
//    public String index(Model model) {
//        List products = service.findAll();
//        model.addAttribute("products", products);
//        return "index";
//    }

    @GetMapping("")
    public String showListProduct(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Sort sort = Sort.by("producer").ascending();
        Page<Product> productList = service.findAllProductPage(PageRequest.of(page, 3, sort));
        model.addAttribute("product", new Product());
        model.addAttribute("productList", productList);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/save")
    public String save(@Validated Product product, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "/create";
        }
        service.save(product);
        redirectAttributes.addFlashAttribute("success", "Create product successfully!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String update(@PathVariable Integer id, Model model) {
        model.addAttribute("product", service.findById(id));
        return "update";
    }

    @PostMapping("/update")
    public String update(@Validated Product product, BindingResult bindingResult, RedirectAttributes redirect) {
        if (bindingResult.hasFieldErrors()) {
            return "/update";
        }
        service.update(product);
        redirect.addFlashAttribute("success", "Updating product successfully!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Integer id, Model model) {
        Product product = service.findById(id);
        model.addAttribute("product", product);
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, Model model, RedirectAttributes redirect) {
        service.remove(product.getId());
        List<Product> productList = service.findAll();
        model.addAttribute("product", new Product());
        model.addAttribute("productList", productList);
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable Integer id, Model model) {
        model.addAttribute("product", service.findById(id));
        return "/view";
    }

    @GetMapping("/search")
    public String searchByName(@RequestParam(name = "page", defaultValue = "0") int page,
                               Product product, Model model) {
        Pageable pageable;
        Sort sort = Sort.by("product_firm").ascending();
        pageable = PageRequest.of(page, 10, sort);
        Page<Product> productList = service.searchByProductName(product.getName(), pageable);
        model.addAttribute("productList", productList);
        return "index";
    }
}
