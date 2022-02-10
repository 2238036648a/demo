package com.example.feignserver.feignController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("feign")
public class FeignTestController {

    @Autowired
    @RequestMapping("test")
    public String test(){
        return "feignserver";
    }
}
