package com.example.ado_frontend.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HomeController {

    String serverName = "http://adobackend:8080/";
    @GetMapping("/")
    public String getWelcome(){
        String uri = serverName+"welcome";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return  result;
    }
}
