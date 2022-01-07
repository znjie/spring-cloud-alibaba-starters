package chuansen.zhan.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient("cloud-service-api-impl-openFeign8084")
public interface MemberService {
    /**
     * 结合@FeignClient("cloud-service-api-impl-openFeign8084")
     * 远程调用/memberImpl/getMemberInfo
     * @return
     */
    @GetMapping("/memberImpl/getMemberInfo")
    String getMemberInfo();

}
