package com.ksit.tms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping(value = "/")
    public String test(){
        System.out.println("TestController.test");
        return "home";
    }
}
