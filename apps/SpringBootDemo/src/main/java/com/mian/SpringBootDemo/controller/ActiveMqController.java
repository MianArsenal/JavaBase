package com.mian.SpringBootDemo.controller;

import com.mian.SpringBootDemo.activemq.producer.SimpleProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activemq")
public class ActiveMqController {

    public static final String SUCCESS = "SUCCESS";
    @Autowired
    private SimpleProducer simpleProducer;
    @Value("simple.producer.queue")
    private String queue;
    @Value("simple.producer.topic")
    private String topic;

    @RequestMapping("/send/queue/{message}")
    public String sendMessageToQueue(@PathVariable String message) {
        this.simpleProducer.sendMessageToQueue(this.queue, message);
        return SUCCESS;
    }

    @RequestMapping("/send/topic/{message}")
    public String sendMessageToTopic(@PathVariable String message) {
        this.simpleProducer.sendMessageToTopic(this.topic, message);
        return SUCCESS;
    }
}
