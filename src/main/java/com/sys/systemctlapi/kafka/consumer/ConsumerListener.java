package com.sys.systemctlapi.kafka.consumer;
import com.sys.systemctlapi.socket.MessageEventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

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
        socketSend(message);
    }

    //接受到指令
    @KafkaListener(topics = "unlockscreenTopicRes")
    public void unlockscreenTopicRes(String message){
        socketSend(message);
    }
    //接受到指令
    @KafkaListener(topics = "calcTopicRes")
    public void calcTopicRes(String message){
        socketSend(message);
    }
    //接受到指令
    @KafkaListener(topics = "shutdownTopicRes")
    public void shutdownTopicRes(String message){
        socketSend(message);
    }
    //接受到指令
    @KafkaListener(topics = "shutdowntenTopicRes")
    public void shutdowntenTopicRes(String message){
        socketSend(message);
    }
    //接受到指令
    @KafkaListener(topics = "shutdownnowTopicRes")
    public void shutdownnowTopicRes(String message){
        socketSend(message);
    }
    //接受到指令
    @KafkaListener(topics = "canceshutdowTopicRes")
    public void canceshutdowTopicRes(String message){
        socketSend(message);
    }
    //接受到指令
    @KafkaListener(topics = "taskmgrTopicRes")
    public void taskmgrTopicRes(String message){
        socketSend(message);
    }
    //接受到指令
    @KafkaListener(topics = "openqqTopicRes")
    public void openqqTopicRes(String message){
        socketSend(message);
    }
    //接受到指令
    @KafkaListener(topics = "closeqqTopicRes")
    public void closeqqTopicRes(String message){
        socketSend(message);
    }
    //接受到指令
    @KafkaListener(topics = "openwechatTopicRes")
    public void openwechatTopicRes(String message){
        socketSend(message);
    }
    //接受到指令
    @KafkaListener(topics = "closewechatTopicRes")
    public void closewechatTopicRes(String message){
        socketSend(message);
    }
    //接受到指令
    @KafkaListener(topics = "seleepTopicRes")
    public void seleepTopicRes(String message){
        socketSend(message);
    }
    //接受到指令
    @KafkaListener(topics = "autoctlTopicRes")
    public void autoctlTopicRes(String message){
        socketSend(message);
    }
    private void socketSend(String message){
        messageEventHandler.socketIoServer.getBroadcastOperations().sendEvent("messageevent", message);
        /*for (UUID clientId : messageEventHandler.listClient) {
            if (messageEventHandler.socketIoServer.getClient(clientId) == null)
                continue;
            //发送消息
           // messageEventHandler.socketIoServer.getClient(clientId).sendEvent("messageevent", message);
        }*/
    }
}