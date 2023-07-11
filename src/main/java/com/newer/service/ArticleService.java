package com.newer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.newer.demo.entity.Article;

import java.util.List;

//package com.newer.service;
//
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.baomidou.mybatisplus.extension.service.IService;
//import com.newer.demo.dao.ArticleDAO;
//import com.newer.demo.dao.StatisticDAO;
//import com.newer.demo.entity.Article;
//import com.newer.demo.entity.Statistic;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.util.List;
//
//@Service
public interface ArticleService  extends IService<Article> {
//    @Resource
//    ArticleDAO articleDAO;
//
//    @Resource
//    StatisticDAO statisticDAO;
//
//
//
//    public List<Article> select(int pageNo,int pageSize){
//        PageRequest request=PageRequest.of(pageNo,pageSize);
//        List<Article> list=articleDAO.findAll(request).getContent();
////        List<Statistic> list1=statisticDAO.findList();
//        System.out.println(request.getPageNumber());
//        System.out.println(request.getPageSize());
//        return list;
//    }
//    public List<Article> selectByHits(){
//        List<Article> list1=articleDAO.findList();
//        System.out.println(list1);
//        return list1;
//    }
//
//
//

    public List<Article> getHeatArticles();


}
