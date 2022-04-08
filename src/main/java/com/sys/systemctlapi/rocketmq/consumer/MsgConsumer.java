package com.sys.systemctlapi.rocketmq.consumer;

import com.sys.systemctlapi.rocketmq.consumer.listeners.MsgTopicListener;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * rocketmq 消费者
 */
@Component
@Slf4j
public class MsgConsumer {
    @Value("${rocketmq.producer.namesrvAddr}")
    private String SERVER_ADDR;
    @PostConstruct
    public  void init() throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("CAR_CONSUMERCC");
        consumer.setNamesrvAddr(SERVER_ADDR);
        //消费策略，从哪里开始消费
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
        consumer.subscribe("SYSCTLTOPIC_RES", "*");
        consumer.registerMessageListener(new MsgTopicListener());
        consumer.start();
        log.info("-Consumer is Started.%n");
    }
}
