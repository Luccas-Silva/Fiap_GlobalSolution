package com.fiap.Java_GlobalSolution.Service;

import com.fiap.Java_GlobalSolution.configs.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerOne {
    private final RabbitTemplate rabbitTemplate;

    public ProducerOne(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendToQueueOne(String message) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY_ONE, message);
    }
}
