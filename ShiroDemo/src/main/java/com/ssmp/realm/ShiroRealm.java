package com.ssmp.realm;

import com.ssmp.entity.User;
import com.ssmp.service.ShiroService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private ShiroService shiroService;

    /**
     * 用户授权，当用户访问需要有权限的页面的情况，需要访问这个方法来获取权限列表
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 获得已经登入过的用户名
        String username = (String) principalCollection.getPrimaryPrincipal();
        // 初始化权限信息
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        // 设置角色
        authorizationInfo.setRoles(shiroService.getRoles(username));
        // 设置权限
        authorizationInfo.setStringPermissions(shiroService.getPermissions(username));

        System.out.println(authorizationInfo.getRoles());
        System.out.println(authorizationInfo.getStringPermissions());
        return authorizationInfo;
    }

    //验证当前登录的用户，获取认证信息。
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //获取用户输入的用户名密码
        String username = (String) token.getPrincipal();
        // 获取数据库中保存的密码
        User user = shiroService.getUser(username);
        // 存在用户
        if (user != null ) {
            // 验证 token和info是否匹配
            return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), ByteSource.Util.bytes(user.getSalt()),getName());
        } else {
            // 当没有用户的时候，抛出异常
            throw new UnknownAccountException("用户名不存在");
        }
    }

    // 清楚缓存
    public void clearCached() {
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principals);
    }
}
