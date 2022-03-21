package com.example.mq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author lcy
 * @since 2022/3/21 10:16
 */
@Service
@Slf4j
public class FanoutComsumer2 {

    @RabbitListener(queues = "lcy-fanout-quyeue1")
    public void getMqMsg(String msg) {
      log.info("消费者2接收消息：" + msg);
    }

}
