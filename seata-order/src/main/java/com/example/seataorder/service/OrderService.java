package com.example.seataorder.service;

import com.example.seataorder.mapper.OrderMapper;
import com.example.seataorder.service.ProductFeignClient;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@Service
@Slf4j
public class OrderService {

    @Autowired
    private ProductFeignClient productFeignClient;

    @Autowired
    private OrderMapper orderMapper;

    public HashMap create(Integer productId) {

        HashMap result = productFeignClient.deduct(productId);
        if (result != null && Boolean.parseBoolean(result.get("result").toString())) {
            HashMap map = new HashMap();
            log.info("数据库开始创建订单");
            orderMapper.insertOrder(productId);
            map.put("result",true);
            return map;
        }
        log.info("创建不了订单");
        return result;
    }
}
