package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.model.EmailSaving;

@Controller
@RequestMapping("email")
public class EmailController {
    @RequestMapping(value = "showForm", method = RequestMethod.GET)

    public String showForm(ModelMap model) {
        model.addAttribute("email", new EmailSaving());
        return "email/update";
    }

    @RequestMapping(value = "/saveEmail", method = RequestMethod.POST)
    public String submit(@ModelAttribute("email") EmailSaving emailSaving, ModelMap modelMap) {
        modelMap.addAttribute("language", emailSaving.getLanguage());
        modelMap.addAttribute("page size", emailSaving.getPageSize());
        modelMap.addAttribute("spam filters", emailSaving.getSpamFilters());
        modelMap.addAttribute("signature", emailSaving.getSignature());
        return "email/info";
    }
}
