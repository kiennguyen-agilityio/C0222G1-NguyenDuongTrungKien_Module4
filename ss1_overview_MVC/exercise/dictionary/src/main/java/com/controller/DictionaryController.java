package com.controller;

import com.service.impl.IDictionaryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    private IDictionaryService service = new IDictionaryService();

    @GetMapping("/")
    public String showHomePage() {
        return "index";
    }

    @PostMapping("/index")
    public String translate(@RequestParam String english, Model model) {
        model.addAttribute("result", service.translate(english));
        model.addAttribute("eng", english);
        model.addAttribute("vietnamese", "vietnamese");
        return "index";
    }
}
