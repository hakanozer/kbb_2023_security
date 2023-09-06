package com.works.controllers;

import com.works.entities.Customer;
import com.works.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class RegisterController {

    final CustomerService customerService;

    @GetMapping("/")
    public String register() {
        Customer c = new Customer();
        c.setEmail("veli@mail.com");
        c.setPassword("1234");
        boolean status = customerService.login(c);
        System.out.println("status: " + status);
        return "register";
    }

    @PostMapping("/register")
    public String customerRegister(@Valid Customer customer, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getFieldErrors());
        } else {
            customerService.save(customer);
        }
        return "register";
        //return "redirect:/";
    }


}
