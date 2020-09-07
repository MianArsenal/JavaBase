package com.mian.tacocloud.demo.mq;

import com.mian.tacocloud.domain.Order;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Message;

@Slf4j
@Service
public class ActiveMqJmsTemplateConsumerServiceDemo {

    private final JmsTemplate jmsTemplate;

    public ActiveMqJmsTemplateConsumerServiceDemo(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }


    public void receiveOrderV0() {
        Message message = this.jmsTemplate.receive("simple.producer.queue");
        try {
            Order order = (Order) ((ActiveMQObjectMessage) message).getObject();
            log.error(order.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void receiveOrderV1() {
        Message message = this.jmsTemplate.receive("demo0.queue");
        try {
            Order order = (Order) ((ActiveMQObjectMessage) message).getObject();
            log.error(order.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void receiveOrderV2() {
        Message message = this.jmsTemplate.receive("demo0.queue");
        try {
            Order order = (Order) ((ActiveMQObjectMessage) message).getObject();
            log.error(order.toString());
            String property = message.getStringProperty("ORDER_PROPERTY");
            log.error(property);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
