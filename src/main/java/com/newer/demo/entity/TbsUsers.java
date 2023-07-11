package com.newer.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Table(name = "t_user")
public class TbsUsers implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="seq_tuser")
    private Integer id;
    @Column(name = "username")
    private String userName;
    @Column(name = "password")
    private String passWord;
    @Column(name="email")
    private String email;
    @Column(name = "created")
    private String created;
    @Column(name = "valid")
    private Integer valid;
}
