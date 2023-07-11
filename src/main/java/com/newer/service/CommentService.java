package com.newer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.newer.demo.dao.CommentDAO;
import com.newer.demo.entity.Comment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service
public class CommentService  {
    @Resource
    CommentDAO commentDAO;

   public List<Comment> selectByArticleId(int id){
       List<Comment> list=commentDAO.selectCommentWithPage(id);
       return list;
   }

   public void pushComment(Comment comment){
       commentDAO.save(comment);
       System.out.println(comment);
   }


   public List<Comment> CommentNew(){
       List<Comment> list=commentDAO.selectNewComment();
       return list;
   }


}
