package chuansen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 1.本地应用读取云端分布式配置中心文件（第一次读取时发送建立长连接）
 * 2.本地应用读取到配置文件后，本地jvm和硬盘都会缓存一份。
 * 3.本地应用于分布式配置中心服务器端一直保持长连接
 * 4.当我们的配置文件发生变化（根据版本号|MD5判断）。将变化结果通知本地应用及时刷新配置文件
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigApplication8085 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication8085.class, args);
    }
}
