package com.chuansen.zhan.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class ProducerController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/getProducerInfo/{paramId}")
    public String getProducerInfo(@PathVariable("paramId") String paramId){
        System.out.println("服务提供者.........");
        return "nacos register, serverport=" + serverPort + "\t 参数:" + paramId;
    }

}
