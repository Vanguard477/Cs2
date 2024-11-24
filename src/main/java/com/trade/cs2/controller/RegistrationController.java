package com.trade.cs2.controller;


import com.trade.cs2.dto.CreateUserDto;
import com.trade.cs2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;


    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("title", "Регистрация");
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") CreateUserDto userDto, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        if (!userDto.getPassword().equals(userDto.getPasswordConfirm())) {
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "registration";
        }

        if (!userService.saveUser(userDto)) {
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "registration";
        }


        return "redirect:/";


    }

}



