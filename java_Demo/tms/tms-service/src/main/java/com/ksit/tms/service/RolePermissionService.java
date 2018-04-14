package com.ksit.tms.service;

import com.ksit.tms.entity.Permission;

import java.util.List;

/**
 * 角色和权限的业务类
 * @author Lvhoufa
 */
public interface RolePermissionService {

    /**
     * 添加权限
     * @param permission
     */
    void insertPermission(Permission permission);

    /**
     * 根据权限类型查询权限
     * @param permissionType
     * @return
     */
    List<Permission> selectPermissionByPermissionType(String permissionType);

    /**
     * 查询所有权限
     * @return
     */
    List<Permission> selectAllPermission();

}
