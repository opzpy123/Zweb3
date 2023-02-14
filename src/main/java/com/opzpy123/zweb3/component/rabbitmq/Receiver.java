package com.opzpy123.zweb3.component.rabbitmq;

import org.springframework.stereotype.Component;

@Component
public class Receiver {

    public void receiveMessage(Object message) {
        System.out.println("Received <" + message + ">");
    }
}
