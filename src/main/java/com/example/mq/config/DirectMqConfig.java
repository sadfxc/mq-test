package com.example.mq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


/**
 * @author lcy
 * @since 2022/3/21 13:55
 */
@Component
public class DirectMqConfig {

    public static String exchangeName = "/lcy-direct-test1";

    public static String queueName1 = "lcy-direct-queue1";

    public static String queueName2 = "lcy-direct-queue2";

    public static String routKey = "directRoutKey";


    @Bean
    public Queue directQueue1() {
        return new Queue(queueName1, true);
    }

    @Bean
    public Queue directQueue2() {
        return new Queue(queueName2, true);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(exchangeName);
    }

    @Bean
    public Binding binding1(Queue directQueue1, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueue1).to(directExchange).with(routKey);
    }

    @Bean
    public Binding binding2(Queue directQueue2, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueue2).to(directExchange).with(routKey);
    }


}
