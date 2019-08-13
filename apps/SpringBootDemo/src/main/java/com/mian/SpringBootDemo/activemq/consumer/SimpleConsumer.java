package com.mian.SpringBootDemo.activemq.consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.stereotype.Component;

import javax.jms.ConnectionFactory;

@Component
public class SimpleConsumer {

    @JmsListener(destination = "simple.producer.queue")
    public void processQueue(String message) {
        System.out.println(message);
    }


    @JmsListener(destination = "simple.producer.topic", containerFactory = "topicFactory")
    public void processTopic(String message) {
        System.out.println(message);
    }

}
