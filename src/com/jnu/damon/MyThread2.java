package com.jnu.damon;

import java.util.concurrent.Callable;

/**
 * Created by Damon on 2017/7/25.
 */
public class MyThread2 implements Callable<String> {
    private String name;
    private int ticket = 10;

    public MyThread2(String name){
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        for(int i = 0; i < 20; i++){
            if(this.ticket > 0){
                System.out.println("买票，剩余票数为" + this.ticket --);
            }
        }
        return "票已卖光";
    }


}
