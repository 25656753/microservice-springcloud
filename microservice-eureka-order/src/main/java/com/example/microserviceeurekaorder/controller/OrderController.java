package com.example.microserviceeurekaorder.controller;

import com.example.microserviceeurekaorder.PO.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @GetMapping("/order/{id}")
    public  Order getorder(@PathVariable("id") String id){
        Order order=new Order("1111","Tbc",434d);
        return  order;
    }
    @GetMapping("/t2")
    public String t2()
    {
        return  "------t2";
    }
}
