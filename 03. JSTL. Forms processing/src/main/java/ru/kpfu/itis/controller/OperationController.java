package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kpfu.itis.service.CalculatorService;

@Controller
public class OperationController {
    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/operations")
    public String getAllOperations(Model model){
        model.addAttribute("operations", calculatorService.findAllLaterThanAnHourAgo());
        return "operations/index";
    }
}
