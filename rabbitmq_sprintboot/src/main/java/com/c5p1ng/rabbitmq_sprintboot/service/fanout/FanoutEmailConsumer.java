package com.c5p1ng.rabbitmq_sprintboot.service.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@RabbitListener(queues = {"email.fanout.queue"})
@Service
public class FanoutEmailConsumer {
    @RabbitHandler
    public void reviceMessage(String message) {
        System.out.println("FanoutEmailConsumer---接收到了订单信息：->" + message);
    }
}
