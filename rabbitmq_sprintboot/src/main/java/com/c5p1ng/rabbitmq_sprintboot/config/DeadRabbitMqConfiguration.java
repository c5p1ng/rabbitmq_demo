package com.c5p1ng.rabbitmq_sprintboot.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeadRabbitMqConfiguration {
    @Bean
    public DirectExchange deadDirect() {
        return new DirectExchange("dead_direct_exchange", true, false);
    }

    @Bean
    public Queue deadQueue() {
        return new Queue("dead.direct.queue", true);
    }

    @Bean
    public Binding deadBinds() {
        return BindingBuilder.bind(deadQueue()).to(deadDirect()).with("dead");
    }
}
