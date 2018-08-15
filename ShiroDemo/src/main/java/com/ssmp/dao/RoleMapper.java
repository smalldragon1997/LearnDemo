package com.ssmp.dao;

import com.ssmp.entity.Role;
import com.ssmp.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

public interface RoleMapper {
    int insert(Role record);

    int insertSelective(Role record);

}