package com.regression.util;

import com.tibco.tibjms.TibjmsQueue;
import com.tibco.tibjms.TibjmsTopic;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

public class EmsTemplate {

    private JmsTemplate jmsQueueTemplate;
    private JmsTemplate jmsTopicTemplate;

    public void sendToQueue(String queue, String message) {
        this.jmsQueueTemplate.send(new TibjmsQueue(queue), new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage();
                textMessage.setText(message);
                return textMessage;
            }
        });
    }

    public void publishToTopic(String topic, String message) {
        this.jmsTopicTemplate.send(new TibjmsTopic(topic), new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage();
                textMessage.setText(message);
                return textMessage;
            }
        });
    }

    public JmsTemplate getJmsQueueTemplate() {
        return jmsQueueTemplate;
    }

    public void setJmsQueueTemplate(JmsTemplate jmsQueueTemplate) {
        this.jmsQueueTemplate = jmsQueueTemplate;
    }

    public JmsTemplate getJmsTopicTemplate() {
        return jmsTopicTemplate;
    }

    public void setJmsTopicTemplate(JmsTemplate jmsTopicTemplate) {
        this.jmsTopicTemplate = jmsTopicTemplate;
    }
}
