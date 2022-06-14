package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.service.impl.ConvertCurrencyServiceImpl;

@Controller
public class CurrencyController {
    private ConvertCurrencyServiceImpl service = new ConvertCurrencyServiceImpl() ;
    @GetMapping("/")
    public String showHomePage(){
        return "index";
    }


    @PostMapping("/index")
    public String convert (@RequestParam String usd, String rate,Model model ){
        model.addAttribute("result",service.count(usd,rate));
        model.addAttribute("usd",usd);
        model.addAttribute("rate",rate);
        return "index" ;
    }
}
