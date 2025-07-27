package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo {

    @Value("${spring.application.name}")
    public String name;

    @GetMapping
    public String getDemo(){
        return name;
    }
}
