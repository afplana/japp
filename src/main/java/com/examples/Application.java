package com.examples;

import ao.jfpack.rabbitmq.pubsub.direct.ConsumeDirect;

public class Application {
    public static void main(String[] args) {
        ConsumeDirect c = new ConsumeDirect();
        Thread t = new Thread(c);
        t.start();
    }
}
