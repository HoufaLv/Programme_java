package com.ksit.tms.mapper;

import com.ksit.tms.entity.RolesHasTPermissionExample;
import com.ksit.tms.entity.RolesHasTPermissionKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolesHasTPermissionMapper {
    long countByExample(RolesHasTPermissionExample example);

    int deleteByExample(RolesHasTPermissionExample example);

    int deleteByPrimaryKey(RolesHasTPermissionKey key);

    int insert(RolesHasTPermissionKey record);

    int insertSelective(RolesHasTPermissionKey record);

    List<RolesHasTPermissionKey> selectByExample(RolesHasTPermissionExample example);

    int updateByExampleSelective(@Param("record") RolesHasTPermissionKey record, @Param("example") RolesHasTPermissionExample example);

    int updateByExample(@Param("record") RolesHasTPermissionKey record, @Param("example") RolesHasTPermissionExample example);
}