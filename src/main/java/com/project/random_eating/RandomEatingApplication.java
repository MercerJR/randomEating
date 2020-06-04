package com.project.random_eating;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.project.random_eating.dao"})
public class RandomEatingApplication {

    public static void main(String[] args) {
        SpringApplication.run(RandomEatingApplication.class, args);
    }

}
