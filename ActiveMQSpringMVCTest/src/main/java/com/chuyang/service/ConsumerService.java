package com.chuyang.service;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.TextMessage;

@Service
public class ConsumerService {

    @Resource(name = "jmsTemplate")
    private JmsTemplate jmsTemplate;

    public TextMessage receive(Destination destination) {

        TextMessage textMessage = (TextMessage) jmsTemplate.receive(destination);

        System.out.println("Get message from " + destination.toString() + ": " + textMessage.toString());

        return textMessage;
    }



}
