package com.newer;

import com.newer.demo.dao.ADAO;
import com.newer.demo.dao.CommentDAO;
import com.newer.demo.dao.StatisticDAO;
import com.newer.demo.entity.Article;

import com.newer.demo.entity.Comment;
import com.newer.demo.entity.Statistic;
import com.newer.service.AService;
import com.newer.service.CommentService;
import com.newer.service.SendEmailService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
class TestXm0608ApplicationTests {

    @Resource
    ADAO adao;

    @Resource
    CommentService commentService;

    @Resource
    StatisticDAO dao;

    @Test
    public void test(){
        this.adao.deleteById(5);
        System.out.println(1234);
    }







}
