package com.ksit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class staticResourceController {

    @GetMapping(value = "/img")
    public String img(){
        return "img";
    }
}
