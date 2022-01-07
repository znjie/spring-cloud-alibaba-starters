package chuansen.zhan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 直接访问该服务 localhost:8083/member/getMemberInfo
 * 远程调用具体实现类 cloud-service-api-impl-openFeign8084
 *
 *
 *
 * Feign与OpenFeign
 * Feign是一个开源声明式WebService客户端，用于简化服务通信
 * Feign采用“接口+注解”方式开发，屏蔽了网络通信的细节
 * OpenFeign是SpringCloud对Feign的增强，用于简化Feign开发
 */
@SpringBootApplication
@EnableFeignClients   //开启OpenFeign实现服务间REST通信
public class OpenFeignApplication8083 {

    public static void main(String[] args) {
        SpringApplication.run(OpenFeignApplication8083.class,args);
    }
}
