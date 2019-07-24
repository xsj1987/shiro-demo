package com.demo.shirodemo.shiro.filter;

import com.demo.shirodemo.shiro.token.PasswordToken;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@Slf4j
public class MyAccessControllerFilter extends AccessControlFilter {

    /**
     * 表示是否允许访问，如果允许访问返回true，否则返回false
     * 如果isAccessAllowed返回true则onAccessDenied方法不会继续执行
     * @param servletRequest
     * @param servletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        return false;
    }

    /**
     * 如果onAccessDenied也返回false，则直接返回，不会进入请求的方法（只有isAccessAllowed和onAccessDenied的情况下）
     * @param servletRequest
     * @param servletResponse
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        log.info("开始执行onAccessDenied方法");
        Subject subject= SecurityUtils.getSubject();
        String userName = servletRequest.getParameter("name");
        String pwd = servletRequest.getParameter("pwd");
        AuthenticationToken token = new PasswordToken(userName, pwd);
        try{
            subject.login(token);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            log.error("登录失败:" + e.getMessage());
            return false;
        }
    }
}
