package com.fiap.Java_GlobalSolution.configs;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_ONE = "queueOne";
    public static final String QUEUE_TWO = "queueTwo";
    public static final String EXCHANGE = "mainExchange";
    public static final String ROUTING_KEY_ONE = "key.one";
    public static final String ROUTING_KEY_TWO = "key.two";

    @Bean
    public Queue queueOne() {
        return new Queue(QUEUE_ONE, true);
    }

    @Bean
    public Queue queueTwo() {
        return new Queue(QUEUE_TWO, true);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    public Binding bindingOne(Queue queueOne, DirectExchange directExchange) {
        return BindingBuilder.bind(queueOne).to(directExchange).with(ROUTING_KEY_ONE);
    }

    @Bean
    public Binding bindingTwo(Queue queueTwo, DirectExchange directExchange) {
        return BindingBuilder.bind(queueTwo).to(directExchange).with(ROUTING_KEY_TWO);
    }
}
