package com.fiap.Java_GlobalSolution.Service;

import com.fiap.Java_GlobalSolution.configs.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerTwo {
    @RabbitListener(queues = RabbitMQConfig.QUEUE_TWO)
    public void receiveFromQueueTwo(String message) {
        System.out.println("ConsumerTwo recebeu: " + message);
    }
}
