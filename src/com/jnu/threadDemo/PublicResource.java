package com.jnu.threadDemo;

/**
 * Created by Damon on 2017/7/25.
 * 公共资源类
 */
public class PublicResource {
    private int number = 0;
    private int maxSize = 5;

    /**
     * 增加公共资源
     */
    public synchronized void increace(){
        while(number == maxSize){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        number ++;
        System.out.println("生成了一个资源，目前资源数为：" + number);
        notify();
    }

    /**
     * 减少公共资源
     */
    public synchronized void decreace(){
        while(number == 0){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        number --;
        System.out.println("减少一个资源，目前资源数为：" + number);
        notify();
    }
}
