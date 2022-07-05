package com.codegym.controller;

import com.codegym.model.person.customer.Customer;
import com.codegym.model.person.customer.CustomerType;
import com.codegym.service.customer.impl.CustomerService;
import com.codegym.service.customer.impl.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService service;
    @Autowired
    private CustomerTypeService customerTypeService;

    @ModelAttribute("customerTypes")
    public List<CustomerType> getCustomerTypes() {
        return customerTypeService.findAll();
    }

    @GetMapping("")
    public String showList(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Sort sort = Sort.by("name").ascending();
        model.addAttribute("customerList", service.findAll(PageRequest.of(page, 10, sort)));
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        model.addAttribute("customer", new Customer());
        return "customer/list_customer";
    }

    @PostMapping("/save")
    public String save(Customer customer, RedirectAttributes redirectAttributes){
        service.save(customer);
        redirectAttributes.addFlashAttribute("msg", "Customer created successfully!!");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable String id, Model model){
        model.addAttribute("customer", service.findById(id));
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        return "customer/edit";
    }

    @PostMapping("/update")
    public String update(Customer customer, RedirectAttributes redirectAttributes){
        service.update(customer);
        redirectAttributes.addFlashAttribute("msg", "Customer edited successfully!!");
        return "redirect:/customer";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        service.delete(id);
        return "redirect:/customer/";
    }

}
