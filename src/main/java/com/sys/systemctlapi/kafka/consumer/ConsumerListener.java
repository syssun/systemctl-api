package com.sys.systemctlapi.kafka.consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * 消费者监听 topic
 */
@Component
public class ConsumerListener {
    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;
    //接受到指令
    @KafkaListener(topics = "lockscreenTopicRes")
    public void lockscreenTopicRes(String message){
        System.out.println("接收到结果指令");
        System.out.println(message);  //通过socket 发送到终端
    }
}