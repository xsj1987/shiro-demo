package com.demo.shirodemo.shiro.token;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.shiro.authc.AuthenticationToken;

/**
 * 通过shiro验证的用户会将需要验证的信息封装在实现了AuthenticationToken接口的实现类中，可以自定义
 * 也可以使用shiro提供的，比如用户名密码的Token[UsernamePasswordToken]
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasswordToken implements AuthenticationToken {

    private String userName;

    private String pwd;

    @Override
    public Object getPrincipal() {
        return this.userName;
    }

    @Override
    public Object getCredentials() {
        return this.pwd;
    }
}
