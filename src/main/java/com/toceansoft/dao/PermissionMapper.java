package com.toceansoft.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.toceansoft.model.Permission;

public interface PermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
    List<String> getPermissions(@Param("account")String account);
}