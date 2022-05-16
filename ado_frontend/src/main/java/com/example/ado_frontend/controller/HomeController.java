package com.example.ado_frontend.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HomeController {

    @Value("${backend.url:defaultValue}")
    private String serverName;
    @GetMapping("/")
    public String getWelcome(){
        String uri = serverName+"welcome";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return  result;
    }
}
