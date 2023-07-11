package com.newer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.newer.demo.dao.ADAO;
import com.newer.demo.dao.ArticleDAO;
import com.newer.demo.entity.Article;
import com.newer.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleDAO, Article> implements ArticleService {

    @Autowired
     ArticleDAO articleDAO;
    @Autowired
    ADAO adao;

    @Override
    public List<Article> getHeatArticles() {
        List<Article> articleList=adao.findList();
        return articleList;
    }
}
