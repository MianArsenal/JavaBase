package com.mian.tacocloud.demo.mq;

import com.mian.tacocloud.domain.Order;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;

@Slf4j
@Component
public class ActiveMqListenerDemo {

    @JmsListener(destination = "demo1.queue")
    public void receiveOrder(Order order) {
        log.error(order.toString());
    }

    @JmsListener(destination = "demo2.queue")
    public void receiveOrder(Message message) {
        try {
            String property = message.getStringProperty("ORDER_PROPERTY");
            log.error(property);
            Order order = (Order) ((ActiveMQObjectMessage) message).getObject();
            log.error(order.toString());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
