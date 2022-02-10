package com.example.rocketmqtest.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class ProducerTest {


    @Value("192.168.43.119:9876")
    private String serverName;

    @Value("userCoupon")
    private String defaultName;


    public static void main(String[] args) throws Throwable {

        DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name");
        producer.setNamesrvAddr("localhost:9876");

        try {
            Message message = new Message("TopicTest", "test", "hello".getBytes());

            producer.start();

            SendResult send = producer.send(message);
            System.out.println("11111111111111111"+send);
            producer.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
