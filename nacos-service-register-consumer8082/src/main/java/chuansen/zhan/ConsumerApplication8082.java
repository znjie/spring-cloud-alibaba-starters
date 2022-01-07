package chuansen.zhan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 服务注册（消费者）  远程调用 生产者的接口
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerApplication8082 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication8082.class, args);
    }
}
