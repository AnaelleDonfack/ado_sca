package com.example.ado_backend.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class GetDataController {

    @Value("${app.description:defaultValue}")
    private String description;
    Logger logger = LoggerFactory.getLogger(GetDataController.class);
    @GetMapping("/welcome")
    public String getText(){
        logger.info("Le frontend vient de me contacter");
        return description;
    }
}
