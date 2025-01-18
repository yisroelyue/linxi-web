package com.yy.linxiweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yy.linxiweb.dao")
public class LinxiWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(LinxiWebApplication.class, args);
    }

}
