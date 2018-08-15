package com.ssmp.service;

import com.ssmp.entity.User;

import java.util.List;
import java.util.Set;

public interface ShiroService {
    User getUser(String username);

    List<User> getAllUser();
    Set<String> getRoles(String username);

    Set<String> getPermissions(String username);

    boolean register(String username,String password);

    boolean addRole(int uid,int rid);
    boolean addPermission(int uid,int rid);

}
