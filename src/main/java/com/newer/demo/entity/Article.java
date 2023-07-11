package com.newer.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
//@Table(name = "t_article")
@TableName("t_article")
public class Article implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private Integer id;

    @Column(name = "titile")
    private String titile;

    @Column(name="content")
    private String content;

    @Column(name="created")
    private String created;

    @Column(name="modified")
    private String modified;

    @Column(name="categories")
    private String categories;

    @Column(name="tage")
    private String tage;

    @Column(name="allowcomment")
    private Integer  allowcomment;

    @Column(name = "thumbnail")
    private String thumbnail;

//    @ManyToOne(targetEntity = Statistic.class)
//    @JoinColumn(name = "fk_sta_com",referencedColumnName ="article_id" )
//    private Statistic statistic;





}
