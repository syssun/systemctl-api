package com.sys.systemctlapi.rocketmq.producer;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Configuration
public class ProducerUtils {
    @Resource(name = "myDefaultMQProducer")
    private DefaultMQProducer defaultMQProducer;

    public void send(String tag,String msg){
        Message message = new Message();
        message.setTopic("SYSCTLTOPIC");
        message.setTags(tag);
        message.setBody(msg.getBytes());
        try {
            defaultMQProducer.send(message,1000l);
        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
