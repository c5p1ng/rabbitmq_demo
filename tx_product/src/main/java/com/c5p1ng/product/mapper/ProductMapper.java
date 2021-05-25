package com.c5p1ng.product.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.c5p1ng.core.entity.Order;

@Mapper
public interface ProductMapper {
	public int update(Order order);
}
