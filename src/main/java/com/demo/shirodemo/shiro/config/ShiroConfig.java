package com.demo.shirodemo.shiro.config;

import com.demo.shirodemo.shiro.filter.MyAccessControllerFilter;
import com.demo.shirodemo.shiro.realm.PasswordRealm;
import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

//@Configuration
public class ShiroConfig {

    /**
     * 安全管理器
     * setRealm：设置Realm实例，也可以通过setRealms设置多个Realm实例，通过集合注入
     * setAuthenticator：Realm管理器，主要用来管理多个Realm的验证规则，单个不用设置
     * @return
     */
    public SecurityManager securityManager(){
        DefaultSecurityManager securityManager = new DefaultWebSecurityManager();
        // 该设置要在Realm设置之前，否则会报找不到Realm异常
        securityManager.setAuthenticator(modularRealmAuthenticator());
        securityManager.setRealm(new PasswordRealm());
        return securityManager;
    }

    /**
     * 用来设置多个Realm的验证规则，Shiro提供的规则有如下几种
     * AtLeastOneSuccessfulStrategy 验证所有Realm，并且至少一个生效
     * AllSuccessfulStrategy 全部验证通过，即所有Realm生效
     * FirstSuccessfulStrategy 只要有一个生效就不会去验证其它的Realm
     *
     * 也可以自定义验证规则，继承ModularRealmAuthenticator并实现doAuthenticate方法即可
     * @return
     */
    public ModularRealmAuthenticator modularRealmAuthenticator(){
        ModularRealmAuthenticator realmAuthenticator = new ModularRealmAuthenticator();
        realmAuthenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
        return realmAuthenticator;
    }

    /**
     * 设置过滤规则
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        // 设置安全管理器
        factoryBean.setSecurityManager(securityManager);
        // 设置过滤器
        factoryBean.setFilters(initFilters());
        // 设置URL拦截器
        factoryBean.setFilterChainDefinitionMap(initFilterChain());
        return factoryBean;
    }

    /**
     * 添加过滤器
     * 过滤器主要是针对于URL拦截器应用，即URL拦截器如果设置了该过滤器，那么过滤器就会根据验证规则对URL进行过滤验证
     * Shiro提供了几种过滤器 anon-表示URL可以匿名访问 auth-表示URL必须通过认证才能访问
     * @return
     */
    public Map<String, Filter> initFilters(){
        Map<String, Filter> map = new LinkedHashMap<>();
        // 只能通过new注入，不能通过@Autowired注入
        map.put("my", new MyAccessControllerFilter());
        return map;
    }

    /**
     * 设置URL拦截器
     * 用来给不同的URL配置不同的过滤器
     * @return
     */
    public Map<String, String> initFilterChain(){
        Map<String, String> map = new LinkedHashMap<>();
        map.put("/js", "my");
        map.put("/css", "anon");
        map.put("/**", "anon");
        return map;
    }

}
