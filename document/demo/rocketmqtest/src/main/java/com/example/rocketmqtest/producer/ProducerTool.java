package com.example.rocketmqtest.producer;/**
 * @program: 7project
 * @description:
 * @author: adh
 * @create: 2020-08-02 13:17
 */

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName ProducerTool
 * @Description: TODO
 * @Author adh
 * @Date 2020/8/2
 * @Version V1.0
 **/
@Component
@Slf4j
public class ProducerTool {

    @Value("localhost:9876")
    private String serverName;

    @Value("userCoupon")
    private String defaultName;

    /*private static  DefaultMQProducer mqClient;*/

    @Autowired
    private ProducerTest producerTest;
    public DefaultMQProducer ProducerTool(){
        //名称
        DefaultMQProducer producer = new DefaultMQProducer("userCoupon");

        producer.setNamesrvAddr("localhost:9876");
       return producer;
    }

    public void testSendMessage(String top,String ages,String value){

        DefaultMQProducer producer = ProducerTool();
        try {
            producer.start();
            //message
            Message msg = new Message(top, ages, value
                    .getBytes());
            SendResult send = producer.send(msg);
            System.out.println("11111111111111111"+send);
            producer.shutdown();

        } catch (Exception e) {
            log.error("testSendMessage error" , e);
            e.printStackTrace();
        }

    }



}
