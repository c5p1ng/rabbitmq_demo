package com.c5p1ng.rabbitmq_sprintboot.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitMqConfiguration {
    // 1：声明注册fanout模式的交换机
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanout_order_exchange", true, false);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("direct_order_exchange", true, false);
    }

    @Bean
    public DirectExchange ttlDirectExchange() {
        return new DirectExchange("ttl_direct_exchange", true, false);
    }

    // 2：声明队列 sms.fanout.queue email.fanout.queue
    @Bean
    public Queue smsQueue() {
        return new Queue("sms.fanout.queue", true);
    }
    @Bean
    public Queue emailQueue() {
        return new Queue("email.fanout.queue", true);
    }

    @Bean
    public Queue smsDirectQueue() {
        return new Queue("sms.direct.queue", true);
    }
    @Bean
    public Queue emailDirectQueue() {
        return new Queue("email.direct.queue", true);
    }

    @Bean
    public Queue ttlDirectQueue() {
        //设置过期时间
        Map<String, Object> args = new HashMap<>();
        args.put("x-message-ttl", 5000);
        args.put("x-dead-letter-exchange", "dead_direct_exchange");//设置死信队列，兜底
        args.put("x-dead-letter-routing-key", "dead");
        return new Queue("ttl.direct.queue", true, false, false, args);
    }
    // 3：完成绑定关系
    @Bean
    public Binding smsBinding() {
        return BindingBuilder.bind(smsQueue()).to(fanoutExchange());
    }
    @Bean
    public Binding emailBinding() {
        return BindingBuilder.bind(emailQueue()).to(fanoutExchange());
    }
    @Bean
    public Binding smsDirectBinding() {
        return BindingBuilder.bind(smsDirectQueue()).to(directExchange()).with("sms");
    }
    @Bean
    public Binding emailDirectBinding() {
        return BindingBuilder.bind(emailDirectQueue()).to(directExchange()).with("email");
    }

    @Bean
    public Binding ttlDirectBinding() {
        return BindingBuilder.bind(ttlDirectQueue()).to(ttlDirectExchange()).with("ttl");
    }
}
