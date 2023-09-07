package com.works.restcontrollers;

import com.works.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerRestController {

    final CustomerService customerService;

    @PostMapping("/customerLogin")
    public boolean customerLogin(
            @RequestParam String email,
            @RequestParam String password
    ) {
        return customerService.login(email,password);
    }

}
