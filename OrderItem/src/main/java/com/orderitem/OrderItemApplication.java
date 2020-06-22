package com.orderitem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class OrderItemApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderItemApplication.class, args);
    }

}
