package com.c5p1ng.rabbitmq_sprintboot;

import com.c5p1ng.rabbitmq_sprintboot.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqSprintbootApplicationTests {

    @Autowired
    private OrderService orderService;

    @Test
    void testOrderSimple() {
        orderService.makeOrder("1", "1", 12);
    }

    @Test
    public void testOrderDirect() {
        orderService.makeOrderDirect("1", "1", 12);
    }

    @Test
    public void testOrderTopic() {
        orderService.makeOrderTopic("1", "1", 12);
    }

    @Test
    public void testOrderTtl() {
        orderService.makeOrderTtl("1", "1", 12);
    }

}
