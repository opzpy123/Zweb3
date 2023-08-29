package com.opzpy123.zweb3;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.opzpy123.zweb3.web.mapper")
public class Zweb3Application {

    public static void main(String[] args) {
        SpringApplication.run(Zweb3Application.class, args);
    }

}
