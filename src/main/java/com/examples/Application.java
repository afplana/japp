package com.examples;

import com.examples.rabbitmq.pubsub.direct.ConsumeDirect;

public class Application {
    public static void main(String[] args) {
        ConsumeDirect c = new ConsumeDirect();
        Thread t = new Thread(c);
        t.start();
    }
}
