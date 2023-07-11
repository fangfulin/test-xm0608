package com.newer.service;

import com.newer.demo.dao.StatisticDAO;
import com.newer.demo.entity.Article;
import com.newer.demo.entity.Statistic;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StatisticService {
    @Resource
    StatisticDAO statisticDAO;

    public long selectCountComment(){
        long comments=statisticDAO.selectCountStatistic();
        return comments;
    }

    public long selectCountSta(){
        long s=statisticDAO.count();
        return s;
    }


}
