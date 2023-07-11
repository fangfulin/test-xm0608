package com.newer.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.newer.demo.entity.Article;
import com.newer.demo.entity.Statistic;
import com.newer.demo.entity.TbsUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface ArticleDAO  extends BaseMapper<Article> {

}
