package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kpfu.itis.service.interfaces.IUserService;
import ru.kpfu.itis.util.UserDto;

import javax.validation.Valid;

@Controller
public class RegistrationController {
    @Autowired
    private IUserService userService;

    @GetMapping("/registration")
    public String index(Model model) {
        model.addAttribute("user", new UserDto());
        return "registration/index";
    }

    @PostMapping("/registration")
    public String newUser(@Valid @ModelAttribute("user") UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration/index";
        }
        if (!userService.saveIfNotExists(userDto)) {
            bindingResult.rejectValue("username", "error.object", "Уже существует");
            return "registration/index";
        }
        return "redirect:/";
    }
}
