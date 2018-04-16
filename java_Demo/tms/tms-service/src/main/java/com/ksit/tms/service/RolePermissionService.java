package com.ksit.tms.service;

import com.ksit.tms.entity.Permission;
import com.ksit.tms.entity.Roles;

import java.util.List;

/**
 * @author houfalv
 * 权限和角色的业务层
 */
public interface RolePermissionService {

    /**
     * 根据type 来查询 permissionList
     * @param buttonType
     * @return
     */
    List<Permission> selectPermissionListByType(String buttonType);

    /**
     * 新增权限
     * @param permission
     */
    void insertPermission(Permission permission);

    /**
     * 查询所有
     * @return
     */
    List<Permission> selectAll();

    /**
     * 根据id 来删除权限
     * @param id
     */
    void deletePermission(Integer id);

    /**
     * 新增角色
     * @param roles         要添加的角色
     * @param permissionId 对应的权限列表
     */
    void insertRoles(Roles roles, Integer[] permissionId);

    /**
     * 查询所有角色信息,不包括权限,权限需要额外查询
     * @return
     */
    List<Roles> selectAllRoles();

    /**
     * 根据id 来查找对应的权限
     * @param id
     * @return
     */
    Permission selectPermissionById(Integer id);

    /**
     * 更新权限
     * @param permission        原来的权限
     */
    void updatePermission(Permission permission);

    /**
     * 查出所有角色和对应的权限列表
     * @return
     */
    List<Roles> selectAllRolesWithPermission();
}
