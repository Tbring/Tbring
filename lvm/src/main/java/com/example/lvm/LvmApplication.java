package com.example.lvm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan({"com.example.lvm.dao"})
@SpringBootApplication
public class LvmApplication {

    public static void main(String[] args) {
        SpringApplication.run(LvmApplication.class, args);
    }

}
