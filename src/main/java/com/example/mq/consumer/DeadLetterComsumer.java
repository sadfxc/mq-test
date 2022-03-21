package com.example.mq.consumer;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author lcy
 * @since 2022/3/21 16:15
 */
@Service
@Slf4j
public class DeadLetterComsumer {

    @RabbitListener(queues = "lcy-direct-queue5-deadletter")
    public void getMsg(String msg, Channel channel, Message message) {
        log.info("死信队列：" + msg);
    }

}
