package com.example.seataproduct;

import com.example.seataproduct.entity.ProductEntity;
import com.example.seataproduct.mapper.ProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductMapper productMapper;

    public HashMap deduct(Long productId) {
        HashMap map = new HashMap();
        //查库存
        ProductEntity productEntity = productMapper.queryProduct(productId);

        if (productEntity == null ) {
            map.put("msg","该商品不参与秒杀活动");
            map.put("result",false);
            return map;
        }

        if (productEntity != null && productEntity.getCount() == productEntity.getTotal()) {
            map.put("msg","抢光了");
            map.put("result",false);
            return map;
        }
        //扣库存
        int reslut = productMapper.updateProduct(productId,productEntity.getCount(),productEntity.getVersion());
        if(reslut == 0){
            map.put("msg","抢购失败，请重试");
            map.put("result",false);
            return map;
        }
        map.put("result",true);
        return map;
    }
}
