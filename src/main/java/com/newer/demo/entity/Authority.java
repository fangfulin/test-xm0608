package com.newer.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "authority")
public class Authority {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "auname")
    private String auName;


}
