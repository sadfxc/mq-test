package com.example.mq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lcy
 * @since 2022/3/21 15:46
 */
@Component
public class DeadLetterMqConfig {

    public static String exchangeName = "/lcy-direct-test3";
    public static String queueName = "lcy-direct-queue5";
    public static String routKey = "directRoutKey";

    public static String dlExchangeName = "/lcy-direct-test3-deadletter";
    public static String dlQueueName = "lcy-direct-queue5-deadletter";
    public static String dlRoutKey = "directRoutKey-deadletter";

    @Bean
    public Queue queue5() {
        Map<String, Object> map = new HashMap<>();
        map.put("x-dead-letter-exchange", dlExchangeName);
        map.put("x-dead-letter-routing-key", dlRoutKey);
        map.put("x-message-ttl", 10000);
        return QueueBuilder.durable(queueName).withArguments(map).build();
    }

    @Bean
    public DirectExchange exchangeName5() {
        return new DirectExchange(exchangeName);
    }

    @Bean
    public Binding binding5(Queue queue5, DirectExchange exchangeName5) {
        return BindingBuilder.bind(queue5).to(exchangeName5).with(routKey);
    }

    @Bean
    public Queue dlQueue5() {
        return new Queue(dlQueueName);
    }

    @Bean
    public DirectExchange dlExchangeName5() {
        return new DirectExchange(dlExchangeName);
    }

    @Bean
    public Binding dlBinding5(Queue dlQueue5, DirectExchange dlExchangeName5) {
        return BindingBuilder.bind(dlQueue5).to(dlExchangeName5).with(dlRoutKey);
    }




}
