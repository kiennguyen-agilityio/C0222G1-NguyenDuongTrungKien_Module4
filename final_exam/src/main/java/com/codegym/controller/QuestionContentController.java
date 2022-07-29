package com.codegym.controller;

import com.codegym.model.QuestionContent;
import com.codegym.model.QuestionType;
import com.codegym.service.customer.impl.QuestionContentService;
import com.codegym.service.customer.impl.QuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/question")
public class QuestionContentController {
    @Autowired
    private QuestionContentService questionContentService;
    @Autowired
    private QuestionTypeService questionTypeService;

    @ModelAttribute("questionType")
    public List<QuestionType> getCustomerTypes() {
        return questionTypeService.findAll();
    }

    @GetMapping("")
    public String showList(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Sort sort = Sort.by("name").ascending();
        model.addAttribute("questionContentList", questionContentService.findAll(PageRequest.of(page, 3, sort)));
        model.addAttribute("questionTypeList", questionTypeService.findAll());
        model.addAttribute("questionContent", new QuestionContent());
        return "question/list_question";
    }
}
