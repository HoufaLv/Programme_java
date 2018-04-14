package com.ksit.tms.service.impl;

import com.ksit.tms.service.RolePermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色和权限的业务类
 * @author Lvhoufa
 */
@Service
public class RolePermissionServicveImpl implements RolePermissionService {

    /**
     * 记录日志
     */
    public static final Logger logger = LoggerFactory.getLogger(RolePermissionServicveImpl.class);

    /**
     * 自动注入mapper 的实现类
     */
    @Autowired
    private PermissionMapper permissionMapper;

    /**
     * 添加权限
     *
     * @param permission
     */
    @Override
    public void insertPermission(Permission permission) {
        permissionMapper.insertSelective(permission);
        logger.info("添加权限: {}",permission );
    }

    /**
     * 根据权限类型查询权限
     *
     * @param permissionType
     * @return
     */
    @Override
    public List<Permission> selectPermissionByPermissionType(String permissionType) {
        PermissionExample permissionExample = new PermissionExample();
        permissionExample.createCriteria().andPermissionTypeEqualTo(permissionType);
        return permissionMapper.selectByExample(permissionExample);
    }

    /**
     * 查询所有权限
     *
     * @return
     */
    @Override
    public List<Permission> selectAllPermission() {
        PermissionExample permissionExample = new PermissionExample();
        return permissionMapper.selectByExample(permissionExample);
    }
}
