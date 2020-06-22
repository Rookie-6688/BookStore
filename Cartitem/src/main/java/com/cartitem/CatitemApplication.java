package com.cartitem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients("com.cartitem.feign")
@EnableDiscoveryClient
@SpringBootApplication
public class CatitemApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatitemApplication.class, args);
    }

}
