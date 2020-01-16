package com.example.microserviceeurekauser.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class user {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/hellojam")
    public String home() {
        // 根据服务名称，获取服务实例
        List<String> list = discoveryClient.getServices();
        System.out.println("*******************" + list);
        List<ServiceInstance> instances = discoveryClient.getInstances("microservice-eureka-order");

        for (ServiceInstance element : instances) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t" + element.getUri()+"\t"+element.getMetadata());
        }
        System.out.println("---------------->/hellojam");
        return restTemplate.getForObject("http://microservice-eureka-order/t2", String.class);
    }

    @GetMapping("/t1")
    public String t1()
    {
        return  "------t1";
    }

}
