package com.ksit.tms.controller;

import com.ksit.tms.entity.Account;
import com.ksit.tms.exception.ServiceException;
import com.ksit.tms.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Lvhoufa
 */
@Controller
public class HomeController {

    @Autowired
    private AccountService accountService;

    @GetMapping(value = "/")
    public String defaultOption() {
        return "redirect:/login";
    }

    @GetMapping(value = "/home")
    public String home(){
        return "home";
    }

    /**
     * 登陆请求
     *
     * @return
     */
    @GetMapping(value = "/login")
    public String login() {
        return "account/login";
    }

    @PostMapping(value = "/login")
    public String login(String mobile, String passWord, HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes) {

        try {
            //登陆成功后,将这个账户作为当前登陆账户保存到session中去
            Account account = accountService.login(mobile, passWord, httpServletRequest.getRemoteAddr());
            httpServletRequest.getSession().setAttribute("login_account",account);

            return "redirect:/home";
        } catch (ServiceException e) {

            //抛出异常则为登录失败,将失败信息传回页面上,在页面上显示账号,不用重新输入
            redirectAttributes.addFlashAttribute("message",e.getMessage());
            redirectAttributes.addFlashAttribute("mobile",mobile);
            return "redirect:/login";
        }

    }

}
