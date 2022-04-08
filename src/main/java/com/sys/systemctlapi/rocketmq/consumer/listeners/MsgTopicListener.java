package com.sys.systemctlapi.rocketmq.consumer.listeners;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.common.message.MessageExt;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Slf4j
public class MsgTopicListener implements MessageListenerOrderly {

    @Override
    public ConsumeOrderlyStatus consumeMessage(List<MessageExt> list, ConsumeOrderlyContext consumeOrderlyContext) {
        log.info("mq开始处理car的数据");
        try {
            for (MessageExt m : list) {
                String msg = new String(m.getBody(), StandardCharsets.UTF_8);
                log.info("car的数据 m:{}", msg);
            }
        } catch (Exception e) {
            log.error("消息发送失败：", e);
        }
        return ConsumeOrderlyStatus.SUCCESS;
    }

}
