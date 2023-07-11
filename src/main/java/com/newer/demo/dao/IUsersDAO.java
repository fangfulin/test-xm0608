package com.newer.demo.dao;

import com.newer.demo.entity.TbsUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsersDAO extends JpaRepository<TbsUsers,Integer> {
    TbsUsers findByUserName(String userName);
}
