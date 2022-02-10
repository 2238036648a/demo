package com.example.rocketmqtest.test;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class aa {

    @Test
    public void producerTest() throws Exception {
        DefaultMQProducer defaultMQProducer = new DefaultMQProducer("please_rename_unique_group_name");
        // Specify name server addresses.
        defaultMQProducer.setNamesrvAddr("localhost:9876");
        //Launch the instance.
        defaultMQProducer.start();
        for (int i = 0;i<5;i++) {
            Message message = new Message();
            message.setTopic("cluster-topic");
            message.setKeys("key-"+i);
            message.setBody(("this is simpleMQ,my NO is "+i+"---"+new Date()).getBytes());

            SendResult sendResult = defaultMQProducer.send(message);
            System.out.println("i=" + i);
            System.out.println("BrokerName:" + sendResult.getMessageQueue().getBrokerName());
        }
    }
}
