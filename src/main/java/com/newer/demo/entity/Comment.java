package com.newer.demo.entity;


import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "t_comment")
public class Comment  implements Serializable{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="seq_tcomment")
    private Integer id;

    @Column(name = "article_id")
    private Integer articleid;

    @Column(name = "created")
    private String created;

    @Column(name = "ip")
    private String ip;

    @Column(name = "content")
    private String content;

    @Column(name = "status")
    private String status;

    @Column(name = "author")
    private String author;
}
