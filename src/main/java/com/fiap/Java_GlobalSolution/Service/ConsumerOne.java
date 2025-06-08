package com.fiap.Java_GlobalSolution.Service;

import com.fiap.Java_GlobalSolution.configs.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerOne {
    @RabbitListener(queues = RabbitMQConfig.QUEUE_ONE)
    public void receiveFromQueueOne(String message) {
        System.out.println("ConsumerOne recebeu: " + message);
    }
}
