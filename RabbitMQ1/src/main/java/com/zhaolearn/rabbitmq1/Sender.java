package com.zhaolearn.rabbitmq1;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Sender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        Date date = new Date();
        String dateString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        System.out.println("Sender name is TEST: " + dateString);
        this.rabbitTemplate.convertAndSend("TEST", dateString);
    }

    public void fanoutSend() {
        Date date = new Date();
        String dateString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        System.out.println("[FirstFanout] send msg:" + dateString);
        // 注意 第一个参数是我们交换机的名称 ，第二个参数是routerKey 我们不用管空着就可以，第三个是你要发送的消息
        this.rabbitTemplate.convertAndSend("FirstFanout", "", dateString);
    }
}
