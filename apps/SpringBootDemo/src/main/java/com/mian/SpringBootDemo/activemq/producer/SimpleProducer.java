package com.mian.SpringBootDemo.activemq.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.*;

@Component
public class SimpleProducer {

    private final JmsTemplate jmsTemplate;

    @Autowired
    public SimpleProducer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessageToQueue(String queue, String message) {
        this.jmsTemplate.send(queue, session -> {
            TextMessage textMessage = session.createTextMessage();
            textMessage.setText(message);
            return textMessage;
        });
    }

    public void sendMessageToTopic(String topicName, String message) {
        this.jmsTemplate.setDefaultDestination((Topic) () -> topicName);
        this.jmsTemplate.send(session -> {
            TextMessage textMessage = session.createTextMessage();
            textMessage.setText(message);
            return textMessage;
        });
    }
}
