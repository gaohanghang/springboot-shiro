package com.gaohang.springbootshiro.shiro;

import com.gaohang.springbootshiro.domin.User;
import com.gaohang.springbootshiro.service.Userservice;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/01/22 11:07
 */
public class UserRealm extends AuthorizingRealm {

    /**
     * 执行授权逻辑
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");

        // 给资源进行授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        // 添加资源的授权字符串
        // info.addStringPermission("user:add");


        // 到数据库查询当前登录用户的授权字符串
        // 获取当前登录用户
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        User dbUser = userservice.findById(user.getId());

        info.addStringPermission(dbUser.getPerms());
        return info;
    }

    // 注入业务
    @Autowired
    private Userservice userservice;

    /**
     * 执行认证逻辑
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证逻辑");

        // 编写shiro判断逻辑，判断用户名和密码
        // 1.判断用户名
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        String username = token.getUsername();
        User user = userservice.findByName(username);

        if (user == null) {
            // 用户名不存在 // shiro底层会抛出UnknowAccountException
            return null;
        }

        // 2.判断密码
        return new SimpleAuthenticationInfo(user, user.getPassword(), "");
    }
}
