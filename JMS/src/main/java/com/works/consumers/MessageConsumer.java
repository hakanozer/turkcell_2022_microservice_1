package com.works.consumers;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import com.google.gson.Gson;
import com.works.props.MessageData;
import com.works.utils.TinkEncDec;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer implements MessageListener {

    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            try {
                String msg = ((TextMessage) message).getText();
                TinkEncDec tinkEncDec = new TinkEncDec();
                System.out.println("Pull Data : " + msg);
                String decryptString = tinkEncDec.decrypt( msg );
                Gson gson = new Gson();
                MessageData data = gson.fromJson(decryptString, MessageData.class);

                System.out.println( data.getService() );
                System.out.println( data.getResult().getStatus() + " " + data.getResult().getId() );

            } catch (JMSException ex) {
                throw new RuntimeException(ex);
            }
        } else {
            throw new IllegalArgumentException("Message must be of type TextMessage");
        }
    }

}
