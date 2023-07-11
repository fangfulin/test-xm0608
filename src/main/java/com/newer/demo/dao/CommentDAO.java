package com.newer.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.newer.demo.entity.Authority;
import com.newer.demo.entity.Comment;
import com.newer.demo.entity.Statistic;
import org.apache.ibatis.annotations.Insert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface CommentDAO extends JpaRepository<Comment,Integer> {

    @Query(nativeQuery = true,value = "select * from t_comment where article_id=?1 order by id desc ")
     List<Comment> selectCommentWithPage(int id);

    //最新评论
    @Query(nativeQuery = true,value = "select * from t_comment order by  id desc")
    List<Comment> selectNewComment();
}
