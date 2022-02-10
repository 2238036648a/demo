package com.example.zuulserver.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("zuul")
public class ZuulaController {

    @RequestMapping("test")
    public String zuulTest(){
        return "zuulserver";
    }
}
