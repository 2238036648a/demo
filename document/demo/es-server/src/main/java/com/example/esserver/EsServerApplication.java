package com.example.esserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EsServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsServerApplication.class, args);
    }

}
