package com.ssmp.dao;

import com.ssmp.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Set;

public interface UserMapper {
    @Insert(value = {"insert into user (username,password,salt)values(#{username},#{password},#{salt})"})
    int insert(User record);

    @Select(value = {"select * from user where username=#{username}"})
    User selectUser(String username);

    @Select(value = {"select * from user "})
    List<User> selectAllUser();

    @Select(value = {"select r.rolename from user u,role r,ur m where u.username=#{username} and u.id=m.uid and r.id=m.rid"})
    Set<String> selectRolesByUsername(String username);

    @Select(value = {"select p.permission from user u,ur a,permission p,rp b where u.username=#{username} and u.id=a.uid and a.rid=b.rid and b.pid=p.id"})
    Set<String> selectPermissionsByUsername(String username);

    @Insert(value = {"insert into rp (rid,pid) values(#{0},#{1})"})
    int insertRP(int rid,int pid);

    @Insert(value = {"insert into ur (uid,rid) values(#{0},#{1})"})
    int insertUR(int uid,int rid);
}