package com.example.eurekaserver.eurekacontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.beans.PropertyDescriptor;

@Controller
@RequestMapping("eureka")
public class EurekaAController {

    @RequestMapping("/test")
    public String zuulTest(){
        return "eurekaserver";
    }
}
