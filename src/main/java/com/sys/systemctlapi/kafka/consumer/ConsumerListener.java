package com.sys.systemctlapi.kafka.consumer;
import com.sys.systemctlapi.socket.MessageEventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 消费者监听 topic
 */
@Component
public class ConsumerListener {
    @Autowired
    private MessageEventHandler messageEventHandler; //socketio
    //接受到指令
    @KafkaListener(topics = "lockscreenTopicRes")
    public void lockscreenTopicRes(String message){
        System.out.println("接收到结果指令");
        System.out.println(message);  //通过socket 发送到终端
        for (UUID clientId : messageEventHandler.listClient) {
            if (messageEventHandler.socketIoServer.getClient(clientId) == null)
                continue;
            //发送消息
            messageEventHandler.socketIoServer.getClient(clientId).sendEvent("messageevent", message);
        }
    }
}