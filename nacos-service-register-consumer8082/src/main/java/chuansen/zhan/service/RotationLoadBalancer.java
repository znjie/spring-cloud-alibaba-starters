package chuansen.zhan.service;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class RotationLoadBalancer implements LoadBalancer {
    //从0开始
    private AtomicInteger atomicInteger = new AtomicInteger(0);


    @Override
    public ServiceInstance getSingleAddress(List<ServiceInstance> serviceInstances) {
        int index = atomicInteger.incrementAndGet() % serviceInstances.size();
        ServiceInstance serviceInstance = serviceInstances.get(index);
        return serviceInstance;
    }
}
