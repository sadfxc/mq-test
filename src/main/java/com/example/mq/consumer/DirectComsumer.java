package com.example.mq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

/**
 * @author lcy
 * @since 2022/3/21 14:04
 */
@Service
@Slf4j
public class DirectComsumer {

    @RabbitListener(queues = "lcy-direct-queue1")
    public void getMsg1(@Payload String msg) {
      log.info("消费者1获取消息：" + msg);
    }

    @RabbitListener(queues = "lcy-direct-queue2")
    public void getMsg2(String msg) {
      log.info("消费者2获取消息：" + msg);
    }

}
