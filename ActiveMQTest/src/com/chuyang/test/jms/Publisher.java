package com.chuyang.test.jms;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Publisher {

    protected static String brokerURL = "tcp://localhost:61616"; //broker URL
    protected static transient ConnectionFactory factory; //连接工厂
    protected  transient Connection connection;
    protected transient Session session;
    protected transient MessageProducer producer;

    public Publisher() throws JMSException {

        factory = new ActiveMQConnectionFactory(brokerURL);
        connection = factory.createConnection();
        connection.start();
        session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        producer = session.createProducer(null);
    }

    public void close() throws JMSException {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws JMSException {

        Publisher publisher = new Publisher();
        for (int i = 0; i < 10; i++) {
            publisher.sendMessage(String.valueOf(i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        publisher.close();
    }

    protected void  sendMessage(String msg) throws JMSException {

        System.out.println("Send message " + "TOPIC." + msg);
        Destination destination = session.createTopic("TOPIC." + msg); //session创建topic
        Message message = session.createMapMessage(); //session创建message
        message.setStringProperty("MessageKey","MessageValue");
        producer.send(destination, message); //MessageProducer向队列服务器（broker）发送消息

    }
}
