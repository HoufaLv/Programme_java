package com.ksit.tms.controller;

import com.ksit.tms.entity.Roles;
import com.ksit.tms.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

/**
 * @author Lvhoufa
 */
@Controller
@RequestMapping(value = "/manage/role")
public class RolesController {

    @Autowired
    private RolePermissionService rolePermissionService;

    /**
     * 跳转到角色管理 home 页面去
     * @return
     */
    @GetMapping
    public String home(Model model){
        //在跳转到角色页面的时候,将所有的角色查询出来,展示到页面中去
        //所有的角色信息
        //还要查询角色对应的权限信息
        //这样不行,得写一个三表联查,将角色对应的权限名称查出来

        /*List<Roles> rolesList = rolePermissionService.selectAllRoles();*/
        //List<Map<String,String>> rolePermissionService.selectPermissionByRoleId();
        /*model.addAttribute("rolesList",rolesList);*/
        //List rolePermissionService.selectRolesWithPermission();

        List<Roles> rolesList = rolePermissionService.selectAllRolesWithPermission();
        model.addAttribute("rolesList",rolesList);

        return "manage/roles/home";
    }

    @GetMapping(value = "/new")
    public String insertRoles(Model model){
        //查询出所有的权限,传给前端展示
        model.addAttribute("permissionList",rolePermissionService.selectAll());

        return "manage/roles/newRoles";
    }

    /**
     * 新增角色,使用数组来接收权限的列表
     * @param roles
     * @return
     */
    @PostMapping(value = "/new")
    public String insertRoles(Roles roles, Integer[] permissionId, RedirectAttributes redirectAttributes){

        rolePermissionService.insertRoles(roles,permissionId);
        redirectAttributes.addFlashAttribute("message","新增角色成功!");
        return "redirect:/manage/role";
    }

}
