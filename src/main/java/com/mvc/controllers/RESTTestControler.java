package com.mvc.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/test")
public class RESTTestControler {

    @GetMapping()
    public String TestString(){
        return "this is a test string. Time:"+ LocalDateTime.now();
    }
}
