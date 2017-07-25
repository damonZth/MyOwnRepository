package com.jnu.threadDemo;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Damon on 2017/7/25.
 * 使用阻塞队列实现生产者/消费者模式，它提供开箱即用支持阻塞的方法
 * put()和 take()，开发者不需要写困惑的 wait-nofity 代码去实现通信了。
 */
public class ProducerThread_1 implements Runnable {
    private BlockingQueue<Integer> sharedQueue;

    public ProducerThread_1(BlockingQueue sharedQueue){
        this.sharedQueue = sharedQueue;
    }
    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            try{
                System.out.println(Thread.currentThread().getName() +"--"+
                "Produced: " + i);
                sharedQueue.put(i);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
