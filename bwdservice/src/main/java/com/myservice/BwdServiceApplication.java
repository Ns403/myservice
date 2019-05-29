package com.myservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.myservice.dao")
public class BwdServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BwdServiceApplication.class, args);
    }

}
