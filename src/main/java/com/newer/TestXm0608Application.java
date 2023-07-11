package com.newer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.newer.demo.dao")
public class TestXm0608Application {

    public static void main(String[] args) {
        SpringApplication.run(TestXm0608Application.class, args);
    }

}
