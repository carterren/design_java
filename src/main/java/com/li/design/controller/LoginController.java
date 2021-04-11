package com.li.design.controller;

import com.alibaba.fastjson.JSONObject;
import com.li.design.service.WorkerService;
import com.li.design.utils.Consts;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Security;

@RestController
public class LoginController {


    @RequestMapping("/login")
    public Object login(HttpServletRequest request, HttpSession session){

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        JSONObject jsonObject = new JSONObject();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try {
            subject.login(token);
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"登录成功");
        } catch (UnknownAccountException e) {
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"用户名错误!");
        }  catch (IncorrectCredentialsException e){
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"密码错误!");
        }
        return jsonObject;
    }

}
