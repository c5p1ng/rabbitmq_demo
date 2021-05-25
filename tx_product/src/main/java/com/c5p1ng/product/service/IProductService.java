package com.c5p1ng.product.service;

import org.springframework.amqp.core.Message;

import com.rabbitmq.client.Channel;

import com.c5p1ng.core.entity.Order;

public interface IProductService {
	
	public int updateProduct(Order order) throws Exception;
	public void updateProduct4MQ(Order order, Channel channel, Message message) throws Exception;
}
