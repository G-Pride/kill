package com.example.seataorder.service;

import com.example.seataorder.entity.ProductEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@FeignClient(name = "seata-product", url = "http://localhost:8086")
public interface ProductFeignClient {

    @GetMapping("/deduct")
    HashMap deduct(@RequestParam Integer productId);
}
