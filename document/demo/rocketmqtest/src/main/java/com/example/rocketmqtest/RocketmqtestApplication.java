package com.example.rocketmqtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RocketmqtestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RocketmqtestApplication.class, args);
    }

}
