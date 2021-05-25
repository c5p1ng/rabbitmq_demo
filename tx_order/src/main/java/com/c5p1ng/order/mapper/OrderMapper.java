package com.c5p1ng.order.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.c5p1ng.core.entity.Order;

@Mapper
public interface OrderMapper {
	public int insert(Order order);
	public int delete(int orderId);
	public int update(int orderId);
}
