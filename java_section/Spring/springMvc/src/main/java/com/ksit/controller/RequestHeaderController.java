package com.ksit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller()
public class RequestHeaderController {

    @GetMapping(value = "/header",produces = "text/html;charset=UTF-8")
    public ModelAndView getHeaderInformation(@RequestHeader(name = "User-Agent") String userAgent, @RequestHeader(name = "Accept") String accept){
        System.out.println("userAgent = " + userAgent);
        System.out.println("accept = " + accept);

        ModelAndView modelAndView = new ModelAndView("headInf");
        modelAndView.addObject("userAgent",userAgent);
        modelAndView.addObject("accept",accept);

        return modelAndView;
    }

    @GetMapping(value = "/flash",produces = "text/html;charset=UTF-8")
    public String testFlash(RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("message","testMessage");
        return "redirect:/flashShow";
    }

    @GetMapping(value = "/flashShow")
    public String showFlash(){
        return "flash";
    }
}
