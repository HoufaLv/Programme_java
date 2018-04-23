package com.ksit.tms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 票务相关业务控制器
 * 公共前缀为 /ticket
 *
 */
@Controller
@RequestMapping("/ticket")
public class TicketController {


    /**
     * 跳转到票务管理首页
     * @return
     */
    @GetMapping("/storage")
    public String ticketHome(){

        return "ticket/storage/home";
    }

    @GetMapping("")
}