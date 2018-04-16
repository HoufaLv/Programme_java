package com.ksit.tms.controller;

import com.ksit.tms.entity.Account;
import com.ksit.tms.entity.Roles;
import com.ksit.tms.service.AccountService;
import com.ksit.tms.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/manage/account")
public class AccountController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private RolePermissionService rolePermissionService;

    @GetMapping
    public String home(){
        return "manage/account/home";
    }

    @GetMapping(value = "/new")
    public String newAccount(Model model){
        //去添加账户之前,先将所有的角色查出来,然后展示到页面上去
        List<Roles> rolesList = rolePermissionService.selectAllRoles();
        model.addAttribute("rolesList",rolesList);

        return "manage/account/newAccount";
    }

    @PostMapping(value = "/new")
    public String newAccount(Account account,Integer[] rolesIds){
        //将account 和 account 对应的roles 存储到对应关系中去
        accountService.insertAccount(account,rolesIds);
        return null;
    }

}
