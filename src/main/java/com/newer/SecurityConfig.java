package com.newer;

//import com.newer.service.UserDetailsServiceImpl;
import com.newer.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    绑定SpringSecurity提供的UserDetailsService验证用户
    @Autowired
    private UserDetailsServiceImpl userDetailsService;


    @Autowired
    private DataSource dataSource;

    //密码需要设置编码器
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//        密码需要设置编码器
//        3.使用UserDetailsService进行身份人资
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    //授权管理
    protected void configure(HttpSecurity httpSecurity) throws Exception {



        httpSecurity.formLogin()
                        .loginPage("/userLogin").permitAll()//放开登录请求
                .usernameParameter("name")
                        .passwordParameter("pwd")//接收表单文本框输入的用户名和密码
                .defaultSuccessUrl("/selectpage")//配置登录成功后跳转到suc.html此处必须填写后缀.html
                .failureUrl("/userLogin?error=true");//配置登录失败回到login.html页面，反馈错误信息




        //解决非thymeleaf的form表单提交被拦截问题
        httpSecurity.csrf().disable();

        //自定义用户授权管理
        httpSecurity.authorizeRequests()
                //项目的主路径可以放行
                .antMatchers("/").permitAll()
                //需要对template文件夹下静态资源进行统一放行
        //登录可以放行
                .antMatchers("/login/**","/userLogin","/index.do","/user").permitAll()
//                .antMatchers("/detail/user/**").hasRole("USER")//必须拥有角色ROLE_USER才可以访问detail/user/下的所有页面
                .anyRequest().authenticated()  //其他请求必须要经过验证
                .and().formLogin();         //允许表单登录

    }

    @Override
    public void configure(WebSecurity web){
        //解决静态资源被拦截的问题
        web.ignoring().antMatchers("/css/**");
        web.ignoring().antMatchers("/img/**");
    }

}
