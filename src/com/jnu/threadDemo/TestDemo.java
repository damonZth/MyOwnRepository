package com.jnu.threadDemo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by Damon on 2017/7/25.
 */
public class TestDemo {
    public static void main(String[] args){
//        PublicResource resource = new PublicResource();
//
//        new Thread(new ProducerThread(resource)).start();
//        new Thread(new ConsumerThread(resource)).start();
//        new Thread(new ProducerThread(resource)).start();
//        new Thread(new ConsumerThread(resource)).start();

        BlockingQueue sharedQueue = new LinkedBlockingDeque();
        ProducerThread_1 producerThread_1 = new ProducerThread_1(sharedQueue);
        ConsumerThread_1 consumerThread_1 = new ConsumerThread_1(sharedQueue);
        Thread prodThread1 = new Thread(producerThread_1,"生产者线程A");
        Thread prodThread2 = new Thread(producerThread_1,"生产者线程B");
        Thread conmThread1 = new Thread(consumerThread_1,"消费者线程C");
        Thread conmThread2 = new Thread(consumerThread_1,"消费者线程D");
        prodThread1.start();
       // prodThread2.start();
        conmThread1.start();
        //conmThread2.start();
    }
}
