package com.ssmp.service.impl;

import com.ssmp.dao.UserMapper;
import com.ssmp.entity.User;
import com.ssmp.realm.ShiroRealm;
import com.ssmp.service.ShiroService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ShiroServiceImpl  implements ShiroService {

    @Autowired
    private UserMapper userDao;

    @Autowired
    private ShiroRealm shiroRealm;

    @Override
    public User getUser(String username) {
        return userDao.selectUser(username);
    }

    @Override
    public List<User> getAllUser() {
        return userDao.selectAllUser();
    }

    @Override
    public Set<String> getRoles(String username) {
        return userDao.selectRolesByUsername(username);
    }

    @Override
    public Set<String> getPermissions(String username) {
        return userDao.selectPermissionsByUsername(username);
    }

    @Override
    public boolean register(String username, String password) {
        // 盐值
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        // 生成的密码
        String encodedPassword = new SimpleHash("md5",password,salt,2).toString();
        // 载体
        User user = new User();
        user.setUsername(username);
        user.setPassword(encodedPassword);
        user.setSalt(salt);
        // 操作
        if(userDao.insert(user)==1)
            return true;

        return false;
    }

    @Override
    public boolean addRole(int uid, int rid) {

        if (userDao.insertUR(uid,rid)==1){
            shiroRealm.clearCached();
            return true;
        }
        return false;
    }

    @Override
    public boolean addPermission(int uid, int rid) {

        if (userDao.insertRP(uid,rid)==1){
            shiroRealm.clearCached();
            return true;
        }
        return false;
    }
}
