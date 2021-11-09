package com.example.wishlist.controllers;

import com.example.wishlist.models.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class SignupController {

    @ModelAttribute("user")
    public UserModel userModel() {
        return new UserModel();
    }

    @GetMapping
    public String showForm() {
        return "register";
    }

    @PostMapping
    public String submitForm(@Valid @ModelAttribute("user") UserModel user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        return "redirect:/index";
    }
}
