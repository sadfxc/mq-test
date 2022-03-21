package com.example.mq.consumer;

import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

/**
 * @author lcy
 * @since 2022/3/21 14:41
 */
@Service
@Slf4j
public class DirectComsumer2 {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "lcy-direct-queue3", durable = "true"),
            exchange = @Exchange(value = "/lcy-direct-test2", type = "direct"),
            key = "directRoutKey2"),
            ackMode = "MANUAL",
            concurrency = "1"
    )
    public void getMsg1(String msg, Channel channel, Message message) throws Exception {
        log.info("消费者1接收消息:" + msg);
//        log.info("消费者1接收headers:" + JSONObject.toJSONString(message.getMessageProperties().getHeaders()));
//        log.info("消费者1接收message:" + JSONObject.toJSONString(message));
//        Thread.sleep(2000);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "lcy-direct-queue3", durable = "true"),
            exchange = @Exchange(value = "/lcy-direct-test2", type = "direct"),
            key = "directRoutKey2"),
            ackMode = "MANUAL",
            concurrency = "2"
    )
    public void getMsg2(String msg, Channel channel, Message message) throws Exception {
        log.info("消费者2接收消息:" + msg);
//        log.info("消费者2接收headers:" + JSONObject.toJSONString(message.getMessageProperties().getHeaders()));
//        log.info("消费者2接收message:" + JSONObject.toJSONString(message));
//        Thread.sleep(2000);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
    }
}
