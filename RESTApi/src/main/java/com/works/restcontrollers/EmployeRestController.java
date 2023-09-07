package com.works.restcontrollers;

import com.works.entities.Employe;
import com.works.services.EmployeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmployeRestController {

    final EmployeService employeService;

    @PostMapping("/register")
    public Employe register( @RequestBody Employe employe ) {
        return employeService.register(employe);
    }

}
