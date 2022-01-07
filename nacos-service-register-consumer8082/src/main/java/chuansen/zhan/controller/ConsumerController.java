package chuansen.zhan.controller;

import chuansen.zhan.service.LoadBalancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Value("${service-url.nacos-producer-service}")
    private String serverUrl;
    @Value("${service-url.interfaceName}")
    private String interfaceName;

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private DiscoveryClient discoveryClient;
    //自定义负载均衡算法
    @Autowired
    private LoadBalancer loadBalancer;

    //测试远程调用
    @GetMapping(value = "/getConsumerInfo/{paramId}")
    public String getConsumerInfo(@PathVariable("paramId") String paramId) {
        System.out.println("服务消费者 .......... ");
        //String url = String.format("http://%s/%s/%s", serverUrl, interfaceName, paramId);
        String url = String.format("http://127.0.0.1:8081/producer/getProducerInfo/%s", paramId);
        System.out.println("request url:" + url);
        return restTemplate.getForObject(url, String.class);
    }

    //通过服务发现discoveryClient获取生产者服务名进行远程调用
    @GetMapping(value = "/getConsumerRandom/{paramId}")
    public String getConsumerRandom(@PathVariable("paramId") String paramId) {
        List<ServiceInstance> instances = discoveryClient.getInstances(serverUrl);
        ServiceInstance serviceInstance = instances.get(0);
        URI uri = serviceInstance.getUri();
        String reqUrl = uri + "/" + interfaceName + "/" + paramId;
        System.out.println("request url:" + reqUrl);
        return restTemplate.getForObject(reqUrl, String.class);
    }

    //根据生产者服务名从注册中心获取集群列表地址,目前生产者只注册了一个,通过loadBalancerClient的choose函数来负载均衡的选出一个服务实例
    @GetMapping(value = "/getConsumerList/{paramId}")
    public String getConsumerList(@PathVariable("paramId") String paramId) {
        ServiceInstance serviceInstance = loadBalancerClient.choose(serverUrl);
        URI uri = serviceInstance.getUri();
        String reqUrl = uri + "/" + interfaceName + "/" + paramId;
        System.out.println("request url:" + reqUrl);
        return restTemplate.getForObject(reqUrl, String.class);
    }

    //自定义实现负载均衡
    @GetMapping(value = "/getConsumerCustom/{paramId}")
    public String getConsumerCustom(@PathVariable("paramId") String paramId) {
        List<ServiceInstance> instances = discoveryClient.getInstances(serverUrl);
        ServiceInstance serviceInstance = loadBalancer.getSingleAddress(instances);
        URI uri = serviceInstance.getUri();
        String reqUrl = uri + "/" + interfaceName + "/" + paramId;
        System.out.println("request url:" + reqUrl);
        return restTemplate.getForObject(reqUrl, String.class);
    }

}
