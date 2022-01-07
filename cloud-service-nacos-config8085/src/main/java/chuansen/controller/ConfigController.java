package chuansen.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试配置信息
 *
 * @RefreshScope 要在程序运行时能够动态修改配置文件，需要使用注解，刷新长连接
 */
@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {

    @Value("${server.port}")
    private String port;
    //nacos管理平台上配置的属性
    @Value("${chuansen.zhan}")
    private String myName;

    @GetMapping("/getServiceInfo")
    public ResponseEntity getServiceInfo() {
        return ResponseEntity.ok("测试获取服务信息端口：" + port);
    }

    @GetMapping("/getRestServiceInfo")
    public ResponseEntity getRestServiceInfo() {
        return ResponseEntity.ok("测试获取配置中心信息：" + myName);
    }
}
