package com.zhaolearn.rabbitmq1;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    /**
     * 定义队列名
     */
    private final static String STRING = "TEST";

    private final static String FIRSTFANOUT = "FirstFanout";




    /**
     * 定义个fanout交换器
     * @return
     */
    @Bean
    FanoutExchange fanoutExchange() {
        // 定义一个名为fanoutExchange的fanout交换器
        return new FanoutExchange(FIRSTFANOUT);
    }



    /**
     * 定义string队列
     *
     * @return
     */
    @Bean
    public Queue string() {
        return new Queue(STRING);
    }


    @Bean
    public Queue fanoutA() {
        return new Queue("fanout.a");
    }

    @Bean
    public Queue fanoutB() {
        return new Queue("fanout.b");
    }

    @Bean
    public Queue fanoutC() {
        return new Queue("fanout.c");
    }



    /**
     * 将定义的fanoutA队列与fanoutExchange交换机绑定
     * @return
     */
    @Bean
    public Binding bindingExchangeWithA() {
        return BindingBuilder.bind(fanoutA()).to(fanoutExchange());
    }

    /**
     * 将定义的fanoutB队列与fanoutExchange交换机绑定
     * @return
     */
    @Bean
    public Binding bindingExchangeWithB() {
        return BindingBuilder.bind(fanoutB()).to(fanoutExchange());
    }

    /**
     * 将定义的fanoutC队列与fanoutExchange交换机绑定
     * @return
     */
    @Bean
    public Binding bindingExchangeWithC() {
        return BindingBuilder.bind(fanoutC()).to(fanoutExchange());
    }
}