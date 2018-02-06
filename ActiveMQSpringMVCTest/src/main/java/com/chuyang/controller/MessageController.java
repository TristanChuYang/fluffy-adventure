package com.chuyang.controller;

import com.chuyang.service.ConsumerService;
import com.chuyang.service.ProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.TextMessage;

@Controller
public class MessageController {

    private Logger logger = LoggerFactory.getLogger(MessageController.class);

    @Resource(name = "demoQueueDestination")
    private Destination destination;

    @Resource(name = "producerService")
    private ProducerService producerService;

    @Resource(name = "consumerService")
    private ConsumerService consumerService;


    @RequestMapping(value = "/SendMessage", method = RequestMethod.POST)
    @ResponseBody
    public void send(String msg) {

        logger.info(Thread.currentThread().getName() + " send message to JMS start");
        producerService.sendMessage(msg);
        logger.info(Thread.currentThread().getName() + " send message to JMS end");
    }

    @RequestMapping(value = "/ReceiveMessage", method = RequestMethod.POST)
    @ResponseBody
    public Object receive() {

        logger.info(Thread.currentThread().getName() + " receive message to JMS start");
        TextMessage textMessage = consumerService.receive(destination);
        logger.info(Thread.currentThread().getName() + " receive message to JMS end");

        return  textMessage;

    }



}
