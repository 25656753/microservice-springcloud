package com.example.microserviceeurekaorder.PO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
    private String Orderid;
    private String VenderName;
    private  Double amout;
}
