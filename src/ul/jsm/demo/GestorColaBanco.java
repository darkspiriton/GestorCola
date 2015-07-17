/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ul.jsm.demo;

import org.apache.activemq.*;
import javax.jms.*;

/**
 *
 * @author StOn
 */
public class GestorColaBanco {
    private static ActiveMQConnectionFactory connectionFactory;
    private static Connection connection;
    private static Session session;
    private static Destination destination;
    private static boolean transacted = false;
    
    public static void main(String[] args) {
      try {
            connectionFactory = new ActiveMQConnectionFactory(
            ActiveMQConnection.DEFAULT_USER,
            ActiveMQConnection.DEFAULT_PASSWORD,
            ActiveMQConnection.DEFAULT_BROKER_URL);
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(transacted,Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("GestorCola");
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            
                    
            javax.jms.Message message1 = session.createObjectMessage(new String("1/42655079/500/Cancelado"));                   
            //Enviamos un mensaje
            producer.send(message1);
            javax.jms.Message message2 = session.createObjectMessage(new String("2/42655079/400/Cancelado"));                   
            //Enviamos un mensaje
            producer.send(message2);
            javax.jms.Message message3 = session.createObjectMessage(new String("3/42655079/1200/Cancelado"));                   
            //Enviamos un mensaje
            producer.send(message3);            
            javax.jms.Message message4 = session.createObjectMessage(new String("4/42655079/2000/Cancelado"));                   
            //Enviamos un mensaje
            producer.send(message4);            
            javax.jms.Message message5 = session.createObjectMessage(new String("5/42655079/666/Cancelado"));                   
            //Enviamos un mensaje
            producer.send(message5);
     
            System.out.println("Se enviaron 5 mensajes...");
        }
        catch (JMSException e) {
            System.out.print(e);
        }
    }  // TODO code application logic here
    }
    
