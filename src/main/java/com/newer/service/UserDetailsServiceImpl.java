package com.newer.service;


import com.newer.demo.entity.Authority;
import com.newer.demo.entity.TbsUsers;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private TblUsersService usersService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername输入的用户名："+s);
        //通过业务方法获取用户及权限信息
        TbsUsers myuser=usersService.getMyTbsUsers(s);
        List<Authority> authorities=usersService.getMyUsersAuthority(s);
        System.out.println("验证的用户:"+myuser);
        //对用户权限进行封装
        List<SimpleGrantedAuthority> list=authorities.stream().map
                (authority ->new SimpleGrantedAuthority(authority.getAuName())).collect(Collectors.toList());
        //返回封装的UserDetails用户详情类
        if(myuser!=null){
            UserDetails userDetails=new User(myuser.getUserName(), myuser.getPassWord(), list);
            return  userDetails;
        }else {
            //如果查询的用户不存在，必须抛出此异常
            throw new UsernameNotFoundException("当前用户不存在");
        }
    }
}
