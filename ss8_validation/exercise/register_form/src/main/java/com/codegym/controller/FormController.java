package com.codegym.controller;

import com.codegym.model.FormModel;
import com.codegym.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/form")
public class FormController {
    @Autowired
    private FormService service;

    @GetMapping("")
    public ModelAndView showForm() {
        return new ModelAndView("list", "list", new FormModel());
    }

    @PostMapping("")
        public String create(@Validated @ModelAttribute("list") FormModel formModel, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasFieldErrors()) {
            return "list";
        } else {
            service.save(formModel);
            redirectAttributes.addFlashAttribute("msg", "đăng kí thành công");
            return "redirect:/form";
        }
    }
}
