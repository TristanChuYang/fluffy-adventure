package com.chuyang.filter;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class QueueMessageListener implements MessageListener {

    public void onMessage(Message message) {

        TextMessage textMessage = (TextMessage) message;
        System.out.println("<========>Listened text message : " + textMessage.toString());

    }
}
