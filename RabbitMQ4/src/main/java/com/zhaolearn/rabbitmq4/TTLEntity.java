package com.zhaolearn.rabbitmq4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues ="message.center.create")
public class TTLEntity {
    private final static Logger LOGGER = LoggerFactory.getLogger(Sender.class);

    /**
     * 消息消费
     * @RabbitHandler 代表此方法为接受到消息后的处理方法
     */
    @RabbitHandler
    public void recieved(String msg) {
        System.out.println("消费内容：{"+ msg+"}");
//        LOGGER.info("消费内容：{}", msg);
    }
}