package com.demo.shirodemo.shiro.realm;

import com.demo.shirodemo.entity.Permission;
import com.demo.shirodemo.entity.Role;
import com.demo.shirodemo.entity.Users;
import com.demo.shirodemo.service.PermissionService;
import com.demo.shirodemo.service.RoleService;
import com.demo.shirodemo.service.UserService;
import com.demo.shirodemo.shiro.token.PasswordToken;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 自定义实现Realm
 * Realm是核心验证器，用来验证账号信息及权限信息
 */
@Slf4j
public class PasswordRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    /**
     * 授权操作
     * 主要用来给当前用户赋予对应的角色和权限
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 获取用户信息
        Users users = (Users) SecurityUtils.getSubject().getPrincipal();
        // 获取用户角色及权限
        List<Permission> permissions = null;
        List<Role> roleList = roleService.selectUserByName(users.getUserName());
        // 将查询出来的角色及权限赋予SimpleAuthorizationInfo对象
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        for (Role role : roleList){
            info.addRole(role.getCode());
            //info.addStringPermission(pm.getPermis());
            List<Permission> permissionList = permissionService.getPerssionByRoleId(role.getId());
            permissionList.forEach(permission -> info.addStringPermission(permission.getCode()));
        }
        return info;
    }

    /**
     * 重写该方法，返回true，支持自定义Token
     * @param token
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        //return super.supports(token);
        return token instanceof AuthenticationToken;
    }

    /**
     * 验证账号信息
     * 主要用来验证用户的凭证[密码]
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        PasswordToken token = (PasswordToken) authenticationToken;
        String userName = token.getUserName();
        // 根据用户名查找用户信息
        // Users users = null;
        Users users = userService.getUserByName(userName);
        log.info("获取的users信息：" + users);
        // 分别判断信息
        if (users == null){
            throw new UnknownAccountException();
        }
        // 对登录密码做匹配，SimpleAuthenticationInfo中有个位置会获取token中的密码与它做对比，如果一样就正常返回，不一样就抛出异常
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(users.getUserName(), users.getPassword(), getName());
        return info;
    }
}
