package com.newer.service;

import com.newer.demo.dao.AuthorityDAO;
import com.newer.demo.dao.IUsersDAO;
import com.newer.demo.entity.Authority;
import com.newer.demo.entity.TbsUsers;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@CacheConfig(cacheNames = "mytbuser")
@Service
public class TblUsersService {
    @Resource
    IUsersDAO usersDAO;
    @Resource
    AuthorityDAO rolesDAO;
    @Resource
    private RedisTemplate redisTemplate;

    public TblUsersService(){
        System.out.println("tblUserService实例化");
    }

    //业务控制
    public TbsUsers getMyTbsUsers(String userName){
        TbsUsers myUser=null;
        System.out.println("TblUserService启动getMyTbsUser的用户名:"+userName);
        Object o=redisTemplate.opsForValue().get("mytuser_"+userName);
        System.out.println("redisTemplate获取缓存的对象:"+o);
        if(o!=null){
            myUser=(TbsUsers) o;
        }else{
            myUser=usersDAO.findByUserName(userName);
            System.out.println("TblUserService启动userDAO.finByUserName"+myUser);
            if(myUser!=null){
                redisTemplate.opsForValue().set("mytuser_"+userName,myUser);
            }
        }
        return myUser;
    }


    //使用唯一用户名查询用户权限
    public List<Authority> getMyUsersAuthority(String username){
        List<Authority> authorities=null;
        Object o=redisTemplate.opsForValue().get("tbsroleauthorities_"+username);
        if(o!=null){
            authorities=(List<Authority>) o;
        }else {
            authorities=rolesDAO.findAuthoritiesByUsername(username);
            if(authorities.size()>0){
                redisTemplate.opsForValue().set("tbsroleauthorities_"+username,authorities);
            }
        }
        return authorities;

    }
}
