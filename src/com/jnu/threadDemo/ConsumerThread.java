package com.jnu.threadDemo;

/**
 * Created by Damon on 2017/7/25.
 * 消费者线程，负责消费资源
 */
public class ConsumerThread implements Runnable {
    private PublicResource resource;

    public ConsumerThread(PublicResource resource){
        this.resource = resource;
    }
    @Override
    public void run() {
        for(int i = 0; i < 30; i++){
            try{
                Thread.sleep((long)(Math.random()*100));
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            resource.decreace();
        }
    }
}
