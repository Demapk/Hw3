package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kpfu.itis.model.Calculator;
import ru.kpfu.itis.service.CalculatorService;

import javax.validation.Valid;

@Controller
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;

    @GetMapping(value = "/calculator")
    public String getIndexPage(Model model) {
        model.addAttribute("calculator", new Calculator());
        return "calculator/index";
    }

    @PostMapping(value = "/calculator")
    public String getResult(@Valid @ModelAttribute("calculator") Calculator calculator, BindingResult result, Model model) {
        if (!result.hasErrors()) {
            calculatorService.calculateResult(calculator);
            model.addAttribute("result", calculator.getResult());
            calculatorService.saveWithHistory(calculator);
        }
        return "calculator/index";
    }

}
