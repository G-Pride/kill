package com.example.seataproduct.mapper;

import com.example.seataproduct.entity.ProductEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;

@Mapper
public interface ProductMapper  {

    ProductEntity queryProduct(@Param(value = "productId") Long productId);

    Integer updateProduct(@Param(value = "productId")Long productId, @Param(value = "count") Integer count, @Param(value = "version") Integer version);
}
