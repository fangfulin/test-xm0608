package com.newer.demo.dao;

import com.newer.demo.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ADAO extends JpaRepository<Article,Integer> {
    @Query(nativeQuery = true,value = "select * from t_article  a inner join t_statistic s on s.article_id=a.id inner join t_comment c on a.id=c.article_id WHERE ROWNUM <= 10 order by hits desc")
     List<Article> findList();


    @Query(nativeQuery = true,value = "select * from t_article where id=?1")
    Article findId(int id);

    @Query(nativeQuery = true,value = "select * from t_article order by  id desc")
    List<Article> selectNewArt();

    @Query(nativeQuery = true,value = "select * from t_article a inner join t_statistic s on a.id=s.article_id")
    List<Article> selectComm();

    @Query(nativeQuery = true,value = "select * from t_article")
    List<Article> selectList();

    @Query(nativeQuery = true,value = "delete * from t_article where id=?1")
    void deleteById(int id);


}
