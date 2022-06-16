package com.controller;

import com.model.Information;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("medical")
public class MedicalDeclarationController {
    @RequestMapping(value = "showForm", method = RequestMethod.GET)

    public String showForm(ModelMap model) {
        model.addAttribute("medical", new Information());
        return "medical/update";
    }

    @RequestMapping(value = "/saveMedical", method = RequestMethod.POST)
    public String submit(@ModelAttribute("medical") Information information, ModelMap modelMap) {
        modelMap.addAttribute("vehicle", information.getVehicles());
        modelMap.addAttribute("gender", information.getGender());
        modelMap.addAttribute("nationality", information.getNationality());
        modelMap.addAttribute("year", information.getYear());
        return "medical/info";
    }
}