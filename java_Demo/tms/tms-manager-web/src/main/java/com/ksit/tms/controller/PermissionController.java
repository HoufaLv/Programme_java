package com.ksit.tms.controller;

import com.ksit.tms.entity.Permission;
import com.ksit.tms.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/manage/permission")
public class PermissionController {

    @Autowired
    private RolePermissionService rolePermissionService;

    /**
     * 请求到permission 首页去,显示所有权限信息
     * @param model
     * @return
     */
    @GetMapping
    public String home(Model model){
        List<Permission> permissionList = rolePermissionService.selectAllPermission();
        model.addAttribute("permissionList",permissionList);
        return "manage/permission/home";
    }

    /**
     * 新增权限,先将权限数据查出来,然后传给页面的select
     * @param model
     * @return
     */
    @GetMapping(value = "/new")
    public String newPermission(Model model){
        List<Permission> permissionList = rolePermissionService.selectPermissionByPermissionType(Permission.MENU_TYPE);
        model.addAttribute("permissionList",permissionList);
        return "manage/permission/newPermission";
    }


    @GetMapping(value = "/new")
    public String newPermission(Permission permission){

        return null;
    }



}
