package com.newer.service;

import com.newer.demo.dao.ADAO;
import com.newer.demo.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AService {
    @Autowired
    ADAO adao;


    public List<Article> getHeatArticles() {
        List<Article> articleList=adao.findList();
        return articleList;
    }

    public Article selectById(int id){
      Article article=adao.findId(id);
       return  article;
    }


    public List<Article> selectNew(){
        List<Article> list=adao.selectNewArt();
        return list;
    }

    public void insertArticle(Article article){
        Article article1=adao.save(article);
    }

    public List<Article> select(){
        List<Article> list=adao.selectList();
        return list;
    }

    public void removeById(Integer id){
        this.adao.deleteById(id);
    }
}
