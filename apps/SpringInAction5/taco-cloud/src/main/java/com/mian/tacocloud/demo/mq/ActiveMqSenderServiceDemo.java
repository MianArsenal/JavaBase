package com.mian.tacocloud.demo.mq;

import com.mian.tacocloud.domain.Order;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@Service
public class ActiveMqSenderServiceDemo {

    private final JmsTemplate jmsTemplate;

    @Autowired
    public ActiveMqSenderServiceDemo(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendOrderV0(Order order) {
        this.jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(order);
            }
        });
    }

    public void sendOrderV1(Order order) {
        this.jmsTemplate.send(session -> session.createObjectMessage(order));
    }

    public void sendOrderV2(Order order) {
        this.jmsTemplate.send(new ActiveMQQueue("demo0.queue"), session -> session.createObjectMessage(order));
    }

    public void sendOrderV3(Order order) {
        this.jmsTemplate.send("demo0.queue", session -> session.createObjectMessage(order));
    }

    public void sendOrderV4(Order order) {
        this.jmsTemplate.convertAndSend("demo0.queue", order);
    }

    public void sendOrderV5(Order order) {
        this.jmsTemplate.send("demo0.queue", session -> {
            Message message = session.createObjectMessage(order);
            message.setStringProperty("ORDER_PROPERTY", "MiAn's ORDER");
            return message;
        });
    }

    public void sendOrderV6(Order order) {
        this.jmsTemplate.convertAndSend("demo0.queue", order, message -> {
            message.setStringProperty("ORDER_PROPERTY", "MiAn's ORDER");
            return message;
        });
    }

    public void sendOrderV7(Order order) {
        this.jmsTemplate.convertAndSend("demo1.queue", order, message -> message);
    }

    public void sendOrderV8(Order order) {
        this.jmsTemplate.convertAndSend("demo2.queue", order, message -> {
            message.setStringProperty("ORDER_PROPERTY", "MiAn's ORDER");
            return message;
        });
    }

}
