package chuansen.zhan.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    /**
     * 加上@LoadBalanced 即可开启负载均衡功能,配置负载均衡实现RestTemplate,而负载均衡的核心实现类是IRule
     * @return
     */
    @Bean
    //@LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
