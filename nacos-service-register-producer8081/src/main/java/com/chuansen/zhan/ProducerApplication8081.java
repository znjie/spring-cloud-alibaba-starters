package com.chuansen.zhan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 服务注册  生产着、接口提供者
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProducerApplication8081 {
    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication8081.class, args);
    }
}

