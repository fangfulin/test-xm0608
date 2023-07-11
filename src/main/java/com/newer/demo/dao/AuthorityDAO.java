package com.newer.demo.dao;

import com.newer.demo.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorityDAO extends JpaRepository<Authority,Integer> {
    @Query(value = "select a.* from t_user u inner join t_user_authority ua on u.id= ua.userid inner join authority a on a.id=ua.authority_id where u.username=?1",nativeQuery = true)
    public List<Authority> findAuthoritiesByUsername(String userName);

}
