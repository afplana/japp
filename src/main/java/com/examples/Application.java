package com.examples;

import ao.jfpack.rabbitmq.pubsub.direct.ConsumeDirectBook;

public class Application {
    public static void main(String[] args) {
        ConsumeDirectBook c = new ConsumeDirectBook();
        Thread t = new Thread(c);
        t.start();
    }
}
