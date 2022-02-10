package com.example.rocketmqtest.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.common.message.Message;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class SyncProducer {

    public static void main(String[] args) throws Exception {

        //Instantiate with a producer group name.
        DefaultMQProducer producer = new
                DefaultMQProducer("please_rename_unique_group_name");
        // Specify name server addresses.
        producer.setNamesrvAddr("localhost:9876");
        //Launch the instance.
        producer.start();
        int messageCount = 6;
        final CountDownLatch countDownLatch = new CountDownLatch(messageCount);
        for (int i = 0; i < 5; i++) {
            //Create a message instance, specifying topic, tag and message body.
            Message msg = new Message("TopicTest" /* Topic */,
                    "TagA" /* Tag */,
                    ("Hello RocketMQ " +
                            i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
            );
            countDownLatch.countDown();
            //Call send message to deliver message to one of brokers.
            SendResult sendResult = producer.send(msg);
            System.out.printf("%s%n", "111111111111111"+sendResult);
            System.out.printf("%s%n", "111111111111111"+sendResult.getSendStatus());

        }
        //Shut down once the producer instance is not longer in use.
        countDownLatch.await(50, TimeUnit.SECONDS);
       // producer.shutdown();
    }
}
