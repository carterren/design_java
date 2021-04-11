package com.li.design.utils;

import com.li.design.entity.Worker;
import com.li.design.service.WorkerService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义realm
 * */
public class UserRealm extends AuthorizingRealm {

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权！");
        return null;
    }

@Autowired
private WorkerService workerService;
    /**
     *
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证！");

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        Worker worker = workerService.findByUsername(token.getUsername());
        if (worker==null){
            return null;//用户名不存在
        }
        return new SimpleAuthenticationInfo("",worker.getPassword(),"");
    }
}
