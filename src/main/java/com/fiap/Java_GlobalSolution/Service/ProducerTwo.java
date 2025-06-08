package com.fiap.Java_GlobalSolution.Service;

import com.fiap.Java_GlobalSolution.configs.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerTwo {
    private final RabbitTemplate rabbitTemplate;

    public ProducerTwo(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendToQueueTwo(String message) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY_TWO, message);
    }
}
