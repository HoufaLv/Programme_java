package com.ksit.tms.controller;

import com.ksit.tms.entity.TicketStore;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 新增售票点业务处理器
 * @author Lvhoufa
 */
@Controller
@RequestMapping("/manage/storeAcc")
public class TicketStoreController {

    /**
     * 跳到售票点管理的home 页面去
     * @return
     */
    @GetMapping(value = "/home")
    public String home(){
        return "manage/storeAccount/home";
    }

    /**
     * 跳转到新增销售点账户页面
     * 需要两个参数,一个是实体类 ticketStore 实体类,spring 会尝试尽量封装一个和前端字段相同的对象过来
     * 另一个是RedirectAttribute 用于向前端传递信息
     * @return
     */
    @GetMapping(value = "/new")
    public String newStoreAccount(TicketStore ticketStore, RedirectAttributes redirectAttributes){
        //接收信息,将ticketStore 对象
        return "manage/storeAccount/newStoreAccount";
    }


    @PostMapping(value = "/new")
    public String newStoreAccount(){

    }

    @PostMapping
    public String newStoreAccount(int i){

        return "manage/storeAccount/newStoreAccount";
    }



}
