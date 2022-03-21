package com.example.mq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lcy
 * @since 2022/3/21 9:53
 */
@Slf4j
@Component
@RabbitListener(queues = "lcy-fanout-quyeue1")
public class FanoutComsumer1 {

    @RabbitHandler
    public void handler(String msg) {
        log.info("消费者1接受消息：" + msg);
    }

}
