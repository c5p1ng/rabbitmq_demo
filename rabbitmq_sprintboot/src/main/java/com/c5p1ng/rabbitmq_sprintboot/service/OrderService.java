package com.c5p1ng.rabbitmq_sprintboot.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 模拟用户下单
     * @param userId 用户id
     * @param productId 产品id
     * @param num 产品数量
     */
    public void makeOrder(String userId, String productId, int num) {
        // 1：根据商品id查询库存是否充足
        // 2：保存订单
        String orderId = UUID.randomUUID().toString();
        // 3：通过MQ来完成消息的分发
        String exchangeName = "fanout_order_exchange";
        String routingKey = "";
        System.out.println("订单创建成功");
        rabbitTemplate.convertAndSend(exchangeName, routingKey, orderId);
    }

    /**
     * 模拟用户下单
     * @param userId 用户id
     * @param productId 产品id
     * @param num 产品数量
     */
    public void makeOrderDirect(String userId, String productId, int num) {
        // 1：根据商品id查询库存是否充足
        // 2：保存订单
        String orderId = UUID.randomUUID().toString();
        // 3：通过MQ来完成消息的分发
        String exchangeName = "direct_order_exchange";
        String routingKey = "";
        System.out.println("订单创建成功");
        rabbitTemplate.convertAndSend(exchangeName, routingKey, orderId);
    }

    /**
     * 模拟用户下单
     * @param userId 用户id
     * @param productId 产品id
     * @param num 产品数量
     */
    public void makeOrderTopic(String userId, String productId, int num) {
        // 1：根据商品id查询库存是否充足
        // 2：保存订单
        String orderId = UUID.randomUUID().toString();
        // 3：通过MQ来完成消息的分发
        String exchangeName = "topic_order_exchange";
        String routingKey = "com.email";
        System.out.println("订单创建成功");
        rabbitTemplate.convertAndSend(exchangeName, routingKey, orderId);
    }

    /**
     * 模拟用户下单
     * @param userId 用户id
     * @param productId 产品id
     * @param num 产品数量
     */
    public void makeOrderTtl(String userId, String productId, int num) {
        // 1：根据商品id查询库存是否充足
        // 2：保存订单
        String orderId = UUID.randomUUID().toString();
        // 3：通过MQ来完成消息的分发
        String exchangeName = "ttl_direct_exchange";
        String routingKey = "ttl";
        System.out.println("订单创建成功");
        rabbitTemplate.convertAndSend(exchangeName, routingKey, orderId);
    }
}
