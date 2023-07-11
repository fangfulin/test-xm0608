//package com.newer.demo.entity;
//
//
//import com.baomidou.mybatisplus.annotation.TableName;
//import lombok.Data;
//
//import javax.persistence.*;
//import java.io.Serializable;
//
//@Data
//@Entity
//@Table(name = "t_statistic")
//public class Vo implements Serializable {
//    @Id
//    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @SequenceGenerator(name="seq_tstatistic")
//    private Integer id;
//
//    @Column(name = "article_id")
//    private Integer articleid;
//
//    @Column(name = "hits")
//    private Integer hits;
//
//    @Column(name="comments_num")
//    private Integer commentsnum;
//}