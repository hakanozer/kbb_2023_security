package com.works.controllers;

import com.works.entities.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @GetMapping("/")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String customerRegister(@Valid Customer customer, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getFieldErrors());
        } else {
            System.out.println( customer );
        }

        return "register";
        //return "redirect:/";
    }



}
