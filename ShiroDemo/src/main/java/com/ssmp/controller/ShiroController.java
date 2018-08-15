package com.ssmp.controller;

import com.ssmp.entity.User;
import com.ssmp.service.ShiroService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ShiroController {

    @Autowired
    private  ShiroService shiroService;

    @RequestMapping(value = "register",method = RequestMethod.POST)
    public String register(
            @RequestParam(name = "username")String username,
            @RequestParam(name = "password")String password){
        if(shiroService.register(username,password))
            return "success";
        return  "login";
    }
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(
            @RequestParam(name = "username")String username,
            @RequestParam(name = "password")String password){

        try{
            Subject subject = SecurityUtils.getSubject();
            if(subject.isAuthenticated()){
                System.out.println("------------用户已经授权，已经登录-----------");
            }
            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
            token.setRememberMe(true);
            subject.login(token);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "login" ;
    }
    @RequestMapping("logout")
    public String logout(){
        //获取到Subject对象，然后退出
        SecurityUtils.getSubject().logout();
        return "login" ;
    }
    @RequestMapping("admin")
    public String admin(){
        return "admin" ;
    }
    @RequestMapping("user")
    @ResponseBody
    public List<User> user(){
        return shiroService.getAllUser() ;
    }
    @RequestMapping(value = "addRole",method = RequestMethod.POST)
    @ResponseBody
    public boolean addRole(
            @RequestParam(name = "uid")int uid,
            @RequestParam(name = "rid")int rid){
        return shiroService.addRole(uid,rid) ;
    }
    @RequestMapping(value = "addPermission",method = RequestMethod.POST)
    @ResponseBody
    public boolean addPermission(
            @RequestParam(name = "rid")int rid,
            @RequestParam(name = "pid")int pid){
        return shiroService.addPermission(rid,pid) ;
    }
}
