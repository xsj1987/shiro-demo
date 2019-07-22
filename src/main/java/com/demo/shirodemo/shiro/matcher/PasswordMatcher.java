package com.demo.shirodemo.shiro.matcher;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;

/**
 * 密码比较器
 * 用来在Realm中认证的时候效验密码是否正确
 *
 * 默认使用Shiro提供的SimpleCredentialsMatcher进行效验，也可以自定义，实现CredentialsMatcher接口的doCredentialsMatch方法即可
 */
@Slf4j
public class PasswordMatcher implements CredentialsMatcher {

    /**
     * 密码效验方法
     * @param authenticationToken 用户输入的用户名/密码封装的Token对象
     * @param authenticationInfo 根据用户名查询出来的对象
     * @return
     */
    @Override
    public boolean doCredentialsMatch(AuthenticationToken authenticationToken, AuthenticationInfo authenticationInfo) {
        log.info("现在开始执行密码匹配...");
        // 用户输入的密码
        String tokenCredentials = authenticationToken.getCredentials().toString();
        // 通过用户名查询出来的密码
        String infoCredentials = authenticationInfo.getCredentials().toString();

        boolean bool = tokenCredentials.equals(infoCredentials);
        return bool;
    }
}
