package com.example.ado_backend.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetDataController {

    @GetMapping("/welcome")
    public String getText(){

        return "Bienvenue ici";
    }
}
