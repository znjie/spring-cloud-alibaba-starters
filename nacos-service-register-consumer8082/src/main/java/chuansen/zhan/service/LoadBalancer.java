package chuansen.zhan.service;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalancer {
    /**
     * 根据多个不同的地址 返回单个调用rpc地址
     *
     * @param serviceInstances
     * @return
     */
    ServiceInstance getSingleAddress(List<ServiceInstance> serviceInstances);
}
