package com.example.mq.producer;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lcy
 * @since 2022/3/21 10:31
 */
@RestController
public class ProducerContorller {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @GetMapping("/fanout/{num}")
    public String sendFanoutMsg(@PathVariable("num") Integer num) {
        for (Integer i = 0; i < num; i++) {
            amqpTemplate.convertAndSend("/lcy-fanout-test1", "", "hello" + i);
        }
        return "SUCCESS";
    }

    @GetMapping("/direct/{num}")
    public String sendDirectMsg(@PathVariable("num") Integer num) {
        for (Integer i = 0; i < num; i++) {
            amqpTemplate.convertAndSend("/lcy-direct-test1", "directRoutKey", "hello" + i);
        }
        return "SUCCESS";
    }

    @GetMapping("/direct2/{num}")
    public String sendDirectMsg2(@PathVariable("num") Integer num) {
        for (Integer i = 0; i < num; i++) {
            amqpTemplate.convertAndSend("/lcy-direct-test2", "directRoutKey2", "hello" + i, message -> {
                MessageProperties properties = message.getMessageProperties();
                properties.setHeader("userId", "123456");
                return message;
            });
        }
        return "SUCCESS";
    }

    @GetMapping("/direct/dl/{num}")
    public String dlSendDirectMsg(@PathVariable("num") Integer num) {
        for (Integer i = 0; i < num; i++) {
            amqpTemplate.convertAndSend("/lcy-direct-test3", "directRoutKey", "hello" + i, message -> {
                MessageProperties properties = message.getMessageProperties();
                properties.setHeader("userId", "123456");
                return message;
            });
        }
        return "SUCCESS";
    }






}
