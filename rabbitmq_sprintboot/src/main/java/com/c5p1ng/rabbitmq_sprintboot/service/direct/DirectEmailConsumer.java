package com.c5p1ng.rabbitmq_sprintboot.service.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@RabbitListener(queues = {"email.direct.queue"})
@Service
public class DirectEmailConsumer {
    @RabbitHandler
    public void reviceMessage(String message) {
        System.out.println("DirectEmailConsumer---接收到了订单信息：->" + message);
    }
}
