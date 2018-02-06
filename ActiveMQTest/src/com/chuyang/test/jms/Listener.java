package com.chuyang.test.jms;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

public class Listener implements MessageListener {

    @Override
    public void onMessage(Message message) { //真正的处理message
        MapMessage map = (MapMessage) message;
        try {
            String value = map.getString("MessageKey");
            System.out.println("Receive Message : " + value);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
