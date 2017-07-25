package com.jnu.threadDemo;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Damon on 2017/7/25.
 */
public class ConsumerThread_1 implements  Runnable {
    private BlockingQueue<Integer> sharedQueue;

    public ConsumerThread_1(BlockingQueue sharedQueue){
        this.sharedQueue = sharedQueue;
    }
    @Override
    public void run() {
       while(true){
           try{
               System.out.println(Thread.currentThread().getName()  +"--"+
               "Consumer：" + sharedQueue.take());
           }catch (InterruptedException e){
               e.printStackTrace();
           }
       }
    }
}
