package com.newer.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "t_statistic")
public class Statistic implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="seq_tstatistic")
    private Integer id;

    @Column(name = "article_id")
    private Integer articleid;

    @Column(name = "hits")
    private Integer hits;

    @Column(name="comments_num")
    private Integer commentsnum;

//    @OneToMany(targetEntity = Article.class,cascade = CascadeType.ALL)
//    @JoinColumn(name ="fk_sta_com",referencedColumnName = "article_id")
//    private Set<Article> article;

//    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    @JoinColumn(name ="article_id")
//    private Article article;

}
