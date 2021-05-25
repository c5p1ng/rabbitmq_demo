package com.c5p1ng.rabbitmq_sprintboot.service.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@RabbitListener(queues = {"sms.fanout.queue"})
@Service
public class FanoutSmsConsumer {
    @RabbitHandler
    public void reviceMessage(String message) {
        System.out.println("FanoutSmsConsumer---接收到了订单信息：->" + message);
    }
}
