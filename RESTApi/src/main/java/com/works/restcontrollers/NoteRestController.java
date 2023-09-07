package com.works.restcontrollers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/note")
public class NoteRestController {

    @Secured({"ROLE_product", "", ""})
    @GetMapping("/list")
    public String list() {
        return "Note List";
    }

}
