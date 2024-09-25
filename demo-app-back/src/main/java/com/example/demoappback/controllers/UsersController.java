package com.example.demoappback.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UsersController {

    @GetMapping("/users")
    public String greeting() throws Exception {
        throw new Exception("TEST ");
    }
}
