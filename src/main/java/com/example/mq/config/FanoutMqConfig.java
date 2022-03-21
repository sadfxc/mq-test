package com.example.mq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author lcy
 * @since 2022/3/21 9:46
 */
@Component
public class FanoutMqConfig {

    String exchangeName = "/lcy-fanout-test1";

    String queueName = "lcy-fanout-quyeue1";


    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(exchangeName);
    }

    @Bean
    public Queue fanoutQueue() {
        return new Queue(queueName);
    }

    @Bean
    public Binding queueBinding(Queue fanoutQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue).to(fanoutExchange);
    }

}
