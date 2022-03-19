package com.example.seataorder.controller;

import com.example.seataorder.service.OrderService;
import com.google.common.util.concurrent.RateLimiter;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Random;

@Slf4j
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    //定义只有10个令牌的令牌痛
    private RateLimiter rateLimiter = RateLimiter.create(9);

    @GetMapping("/create")
    @GlobalTransactional
    public void create() {
        if (rateLimiter.tryAcquire()) {
            //减少数据库压力
            log.info("恭喜你，进去了！");
            orderService.create(5001);
            //模拟分布式事务
//            if(true){
//                log.info("创建订单出现异常");
//                throw new RuntimeException("创建订单出现异常");
//            }
        } else {
            //阻挡绝大部分请求
            log.info("不好意思，系统繁忙！");
        }
    }
}
