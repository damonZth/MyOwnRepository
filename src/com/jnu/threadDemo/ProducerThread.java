package com.jnu.threadDemo;

/**
 * Created by Damon on 2017/7/25.
 * 生产者线程，负责生产公共资源
 */
public class ProducerThread implements Runnable{
    private PublicResource resource;

    public ProducerThread(PublicResource resource){
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
            resource.increace();
        }
    }
}
