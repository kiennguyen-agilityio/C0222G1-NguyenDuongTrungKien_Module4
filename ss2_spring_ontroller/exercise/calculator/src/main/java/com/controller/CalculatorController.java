package com.controller;
import com.service.impl.ICalculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    private ICalculator calculator = new ICalculator();

    @RequestMapping("/")
    public String homePage() {
        return "index";
    }

    @PostMapping("/calculator")
    public String calculator(@RequestParam("number1") float number1,
                             @RequestParam("number2") float number2,
                             @RequestParam("calculation") String calculation,
                             Model model) {
        float result;
        if (calculation.equals("+")) {
            result = calculator.addition(number1, number2);
            model.addAttribute("result", result);
        } else if (calculation.equals("-")) {
            result = calculator.subtraction(number1, number2);
            model.addAttribute("result", result);
        } else if (calculation.equals("*")) {
            result = calculator.multiplication(number1, number2);
            model.addAttribute("result", result);
        } else if (calculation.equals("/")) {
            result = calculator.division(number1, number2);
            model.addAttribute("result", result);
        }
        return "index";
    }
}
