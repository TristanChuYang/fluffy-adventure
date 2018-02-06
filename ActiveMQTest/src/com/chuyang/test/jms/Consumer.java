package com.chuyang.test.jms;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Consumer {

    private static String brokerURL = "tcp://localhost:61616";
    private static transient ConnectionFactory factory;
    private transient Connection connection;
    private transient Session session;

    public Consumer() throws JMSException {

        factory = new ActiveMQConnectionFactory(brokerURL);
        connection = factory.createConnection();
        connection.start();
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    }

    public void close() throws JMSException {

        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws JMSException {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Consumer consumer = new Consumer();
        for (int i = 0; i < 10; i++) {
            System.out.println("Receive message " + "TOPIC." + i);
            Destination destination = consumer.getSession().createTopic("TOPIC." + i);
            MessageConsumer messageConsumer = consumer.getSession().createConsumer(destination);
            messageConsumer.setMessageListener(new Listener());
        }
    }

    public Session getSession() {

        return  session;
    }
}
