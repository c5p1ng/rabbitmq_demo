package com.c5p1ng.rabbitmq_sprintboot.service.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@RabbitListener(queues = {"sms.direct.queue"})
@Service
public class DirectSmsConsumer {
    @RabbitHandler
    public void reviceMessage(String message) {
        System.out.println("DirectSmsConsumer---接收到了订单信息：->" + message);
    }
}
