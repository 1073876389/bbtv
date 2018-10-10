package com.xuwenxing.bbtv.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 编写我们自己定值的内存用户名密码认证
 *
 * Created by xuwx on 2018/9/4.
 */
@Configuration
/**
 *  1. 通过 @EnableWebSecurity注解开启Spring Security的功能
 * @EnableGlobalMethodSecurity(prePostEnabled = true)这个注解，可以开启security的注解，
 * 我们可以在需要控制权限的方法上面使用@PreAuthorize，@PreFilter这些注解
 * 2. 继承 WebSecurityConfigurerAdapter 类，并重写它的方法来设置一些web安全的细节。
 * 我们结合@EnableWebSecurity注解和继承WebSecurityConfigurerAdapter，来给我们的系统加上基于web的安全机制。
 * 3.
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
 //security 5.0之前的方式 ; 5.0后 需要指定加密方式 {id}password  (id为加密方式,password为加密后的密码)
//               auth.inMemoryAuthentication().withUser("admin").password("admin").roles("USER").
//                and().withUser("1024").password("1024").roles("ADMIN","USER");
                 auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("admin").password(new BCryptPasswordEncoder().encode("admin")).roles("USER");
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        return super.userDetailsService();
    }
}
