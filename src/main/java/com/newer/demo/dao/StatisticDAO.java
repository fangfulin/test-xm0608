package com.newer.demo.dao;

import com.newer.demo.entity.Authority;
import com.newer.demo.entity.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatisticDAO extends JpaRepository<Statistic,Integer> {

    //统计评论数量
    @Query(value = "SELECT sum(comments_num) FROM t_statistic",nativeQuery = true)
    long selectCountStatistic();


    //统计文章数量
    @Query(nativeQuery = true,value = " SELECT COUNT(article_id) FROM t_statistic")
    long count();



}
